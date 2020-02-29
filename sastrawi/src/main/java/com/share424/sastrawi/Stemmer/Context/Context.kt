package com.share424.sastrawi.Stemmer.Context

import com.share424.sastrawi.Dictionary.DictionaryInterface
import com.share424.sastrawi.Stemmer.ConfixStripping.PrecedenceAdjustmentSpecification
import com.share424.sastrawi.Stemmer.Context.Visitor.VisitableInterface
import com.share424.sastrawi.Stemmer.Context.Visitor.VisitorInterface
import com.share424.sastrawi.Stemmer.Context.Visitor.VisitorProvider

/**
 * Created by Surya Mahadi on 29/02/20.
 */

/**
 * Stemming Context using Nazief and Adriani, CS, ECS, Improved ECS
 */
class Context(val originalWord : String, val dictionary : DictionaryInterface, val visitorProvider : VisitorProvider) : VisitableInterface {
    var currentWord = originalWord
    val removals = mutableListOf<Removal>()
    var processIsStopped = false
    val visitors = visitorProvider.visitors
    val suffixVisitors = visitorProvider.suffixVisitors
    val prefixVisitors = visitorProvider.prefixVisitors
    var result : String? = null

    fun stopProcess() {
        processIsStopped = true
    }

    fun addRemoval(removal : Removal) {
        removals.add(removal)
    }

    /**
     * Execute stemming process; the result can be retrieved with getResult()
     */
    fun execute() {
        // step 1 - 5
        startStemmingProcess()

        // step 6
        if(dictionary.contains(currentWord)) {
            result = currentWord
        } else {
            result = originalWord
        }
    }

    fun startStemmingProcess() {
        // step 1
        if(dictionary.contains(currentWord)) {
            return
        }

        acceptVisitors(visitors)

        if(dictionary.contains(currentWord)) {
            return
        }

        val csPrecedenceAdjustmentSpecification = PrecedenceAdjustmentSpecification()
        /*
         * Confix Stripping
         * Try to remove prefix before suffix if the specification is met
         */
        if(csPrecedenceAdjustmentSpecification.isSatisfiedBy(originalWord)) {
            // step 4, 5
            removePrefixes()
            if(dictionary.contains(currentWord)) {
                return
            }

            // step 2, 3
            removeSuffixes()
            if(dictionary.contains(currentWord)) {
                return
            } else {
                // if the trial is failed, restore the original word
                // and continue to normal rule precedence (suffix first, prefix afterwards)
                currentWord = originalWord
                removals.clear()
            }
        }

        // step 2, 3
        removeSuffixes()
        if(dictionary.contains(currentWord)) {
            return
        }

        // step 4, 5
        removePrefixes()
        if(dictionary.contains(currentWord)) {
            return
        }

        // ECS loop pengembalian akhiran
        loopPengembalianAkhiran()
    }

    private fun removePrefixes() {
        for(i in 0..2) {
            acceptPrefixVisitors(prefixVisitors)
            if(dictionary.contains(currentWord)) {
                return
            }
        }
    }

    private fun removeSuffixes() {
        acceptVisitors(suffixVisitors)
    }


    /**
     * TODO
     *
     * @param visitors
     */
    private fun acceptVisitors(visitors : MutableList<VisitorInterface>) : String? {
        visitors.forEach {
            accept(it)
            if(dictionary.contains(currentWord)) {
                return currentWord
            }

            if(processIsStopped) {
                return currentWord
            }
        }
        return null
    }

    /**
     * TODO
     *
     * @param visitors
     */
    private fun acceptPrefixVisitors(visitors : MutableList<VisitorInterface>) : String? {
        val removalCount = removals.size
        visitors.forEach {
            accept(it)
            if(dictionary.contains(currentWord)) {
                return currentWord
            }

            if(processIsStopped) {
                return currentWord
            }

            if(removals.size > removalCount) {
                return null
            }
        }
        return null
    }

    /**
     * ECS Loop Pengembalian Akhiran
     */
    private fun loopPengembalianAkhiran() {
        // restore prefix to form [DP+[DP+[DP]]] + Root word
        restorePrefix()

        var removals = this.removals.toMutableList() // copy the list
        val reversedRemoval = this.removals.toMutableList()
        reversedRemoval.reverse()
        val currentWord = this.currentWord

        reversedRemoval.forEach {
            if(!isSuffixRemoval(it)) {
                return@forEach
            }

            if(it.removedPart == "kan") {
                this.currentWord = it.result + "k"

                // step 4, 5
                removePrefixes()
                if(dictionary.contains(this.currentWord)) {
                    return
                }
            } else {
                this.currentWord = it.subject
            }

            // step 4, 5
            removePrefixes()
            if(dictionary.contains(this.currentWord)) {
                return
            }

            this.removals.clear()
            this.removals.addAll(removals)
            this.currentWord = currentWord
        }
    }

    /**
     * Check wether the removed part is a suffix
     *
     * @param  \Sastrawi\Stemmer\Context\RemovalInterface $removal
     * @return boolean
     */
    private fun isSuffixRemoval(removal : Removal) : Boolean {
        return removal.affixType == "DS"
                || removal.affixType == "PP"
                || removal.affixType == "P"
    }

    /**
     * Restore prefix to proceed with ECS loop pengembalian akhiran
     *
     * @return void
     */
    private fun restorePrefix() {
        run outer@ {
            removals.forEach {
                if(it.affixType == "DP") {
                    // return the word before precoding (the subject of first prefix removal)
                    currentWord = it.subject
                    return@outer
                }
            }
        }

        val tempRemovals = removals.toMutableList()
        removals.forEach {
            if(it.affixType == "DP") {
                tempRemovals.remove(it)
            }
        }
        removals.clear()
        removals.addAll(tempRemovals)
    }

    override fun accept(visitor: VisitorInterface) {
        visitor.visit(this)
    }

}

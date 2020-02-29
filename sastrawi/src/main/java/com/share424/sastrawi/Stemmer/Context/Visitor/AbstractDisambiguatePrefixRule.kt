package com.share424.sastrawi.Stemmer.Context.Visitor

import com.share424.sastrawi.Morphology.Disambiguator.DisambiguatorInterface
import com.share424.sastrawi.Stemmer.Context.Context
import com.share424.sastrawi.Stemmer.Context.Removal

/**
 * Created by Surya Mahadi on 29/02/20.
 */
abstract class AbstractDisambiguatePrefixRule : VisitorInterface {
    val disambiguators = mutableListOf<DisambiguatorInterface>()

    override fun visit(context: Context) {
        var result : String? = null
        run outer@{
            disambiguators.forEach {
                result = it.disambiguate(context.currentWord)
                if(context.dictionary.contains(result)) {
                    return@outer
                }
            }
        }
        if(result == null) {
            return
        }
        val removedPart = Regex(result.toString()).replaceFirst(context.currentWord, "")
        val removal = Removal(
            this,
            context.currentWord,
            result!!,
            removedPart,
            "DP"
        )
        context.addRemoval(removal)
        context.currentWord = result!!
    }

    fun addDisambiguators(disambiguators : MutableList<DisambiguatorInterface>) {
        this.disambiguators.addAll(disambiguators)
    }

    fun addDisambiguator(disambiguator : DisambiguatorInterface) {
        this.disambiguators.add(disambiguator)
    }

    

}
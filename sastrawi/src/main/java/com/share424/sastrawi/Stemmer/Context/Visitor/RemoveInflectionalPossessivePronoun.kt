package com.share424.sastrawi.Stemmer.Context.Visitor

import com.share424.sastrawi.Stemmer.Context.Context
import com.share424.sastrawi.Stemmer.Context.Removal

/**
 * Created by Surya Mahadi on 29/02/20.
 */

/**
 * Remove Inflectional Possessive Pronoun
 *
 * Asian J. (2007) “Effective Techniques for Indonesian Text Retrieval”. page 60
 * @link http://researchbank.rmit.edu.au/eserv/rmit:6312/Asian.pdf
 */
class RemoveInflectionalPossessivePronoun : VisitorInterface{
    override fun visit(context: Context) {
        val result = remove(context.currentWord)
        if(result != context.currentWord) {
            val removedPart = Regex(result).replaceFirst(context.currentWord, "")
            val removal = Removal(
                this,
                context.currentWord,
                result,
                removedPart,
                "PP"
            )
            context.addRemoval(removal)
            context.currentWord = result
        }
    }

    /**
     * Remove inflectional possessive pronoun : ku|mu|nya|-ku|-mu|-nya
     * @param string $word
     */
    fun remove(word : String) : String {
        return Regex("-*(ku|mu|nya)$").replaceFirst(word, "")
    }
}
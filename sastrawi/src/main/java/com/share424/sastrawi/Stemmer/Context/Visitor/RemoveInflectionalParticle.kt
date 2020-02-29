package com.share424.sastrawi.Stemmer.Context.Visitor

import com.share424.sastrawi.Stemmer.Context.Context
import com.share424.sastrawi.Stemmer.Context.Removal

/**
 * Created by Surya Mahadi on 29/02/20.
 */

/**
 * Remove Inflectional particle.
 *
 * Asian J. (2007) “Effective Techniques for Indonesian Text Retrieval”. page 60
 * @link http://researchbank.rmit.edu.au/eserv/rmit:6312/Asian.pdf
 */
class RemoveInflectionalParticle : VisitorInterface {
    override fun visit(context: Context) {
        val result = remove(context.currentWord)
        if(result != context.currentWord) {
            val removedPart = Regex(result).replaceFirst(context.currentWord, "")
            val removal = Removal(
                this,
                context.currentWord,
                result,
                removedPart,
                "P"
            )
            context.addRemoval(removal)
            context.currentWord = result
        }
    }

    /**
     * Remove inflectional particle : lah|kah|tah|pun
     * @param string $word
     */
    fun remove(word : String) : String {
        return Regex("-*(lah|kah|tah|pun)$").replaceFirst(word, "")
    }
}
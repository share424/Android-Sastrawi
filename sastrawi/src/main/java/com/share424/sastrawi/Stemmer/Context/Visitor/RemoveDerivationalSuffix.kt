package com.share424.sastrawi.Stemmer.Context.Visitor

import com.share424.sastrawi.Stemmer.Context.Context
import com.share424.sastrawi.Stemmer.Context.Removal

/**
 * Created by Surya Mahadi on 29/02/20.
 */

/**
 * Remove Derivational Suffix.
 *
 * Asian J. (2007) “Effective Techniques for Indonesian Text Retrieval”. page 61
 * @link http://researchbank.rmit.edu.au/eserv/rmit:6312/Asian.pdf
 */
class RemoveDerivationalSuffix : VisitorInterface {
    override fun visit(context: Context) {
        val result = removeSuffix(context.currentWord)
        if(result != context.currentWord) {
            val removedPart = Regex(result).replaceFirst(context.currentWord, "")
            val removal = Removal(
                this,
                context.currentWord,
                result,
                removedPart,
                "DS"
            )
            context.addRemoval(removal)
            context.currentWord = result
        }

    }

    /**
     * Remove derivational suffix
     * Original rule : i|kan|an
     * Added the adopted foreign suffix rule : is|isme|isasi
     *
     * @param  string $word
     * @return string word after its derivational suffix removed
     */
    fun removeSuffix(word : String) : String {
        return Regex("(is|isme|isasi|i|kan|an)$").replaceFirst(word, "")
    }

}
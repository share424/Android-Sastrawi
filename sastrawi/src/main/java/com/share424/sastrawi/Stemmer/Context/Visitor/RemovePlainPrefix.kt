package com.share424.sastrawi.Stemmer.Context.Visitor

import com.share424.sastrawi.Stemmer.Context.Context
import com.share424.sastrawi.Stemmer.Context.Removal

/**
 * Created by Surya Mahadi on 29/02/20.
 */

/**
 * Remove Plain Prefix.
 *
 * Asian J. (2007) “Effective Techniques for Indonesian Text Retrieval”. page 61
 * @link http://researchbank.rmit.edu.au/eserv/rmit:6312/Asian.pdf
 */
class RemovePlainPrefix : VisitorInterface{
    override fun visit(context: Context) {
        val result = remove(context.currentWord)
        if(result != context.currentWord) {
            val removedPart = Regex(result).replaceFirst(context.currentWord, "")
            val removal = Removal(
                this,
                context.currentWord,
                result,
                removedPart,
                "DP"
            )
            context.addRemoval(removal)
            context.currentWord = result
        }
    }

    /**
     * Remove plain prefix : di|ke|se
     *
     * @param  string $word
     * @return string
     */
    fun remove(word : String) : String {
        return Regex("^(di|ke|se)").replaceFirst(word, "")
    }
}
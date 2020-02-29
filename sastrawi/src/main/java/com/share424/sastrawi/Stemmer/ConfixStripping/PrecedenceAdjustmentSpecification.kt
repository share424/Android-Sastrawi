package com.share424.sastrawi.Stemmer.ConfixStripping

import com.share424.sastrawi.Specification.SpecificationInterface

/**
 * Created by Surya Mahadi on 29/02/20.
 */

/**
 * Confix Stripping Rule Precedence Adjustment Specification.
 * Asian J. (2007) “Effective Techniques for Indonesian Text Retrieval” page 78-79.
 *
 * @link   http://researchbank.rmit.edu.au/eserv/rmit:6312/Asian.pdf
 */
class PrecedenceAdjustmentSpecification : SpecificationInterface {
    override fun isSatisfiedBy(word: String): Boolean {
        val regexRules = listOf(
            "^be(.*)lah$",
            "^be(.*)an$",
            "^me(.*)i$",
            "^di(.*)i$",
            "^pe(.*)i$",
            "^ter(.*)i$"
        )
        regexRules.forEach {
            if(Regex(it).matches(word)) return true
        }
        return false
    }

}
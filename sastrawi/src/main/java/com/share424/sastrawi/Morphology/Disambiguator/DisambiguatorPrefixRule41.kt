package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */


/**
 * Disambiguate Prefix Rule 41
 * Rule 41 : kuA -> ku-A
 */
class DisambiguatorPrefixRule41 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^ku(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1]
        }
        return null
    }

}
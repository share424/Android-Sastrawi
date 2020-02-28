package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 42
 * Rule 42 : kauA -> kau-A
 */
class DisambiguatorPrefixRule42 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^kau(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1]
        }
        return null
    }
}
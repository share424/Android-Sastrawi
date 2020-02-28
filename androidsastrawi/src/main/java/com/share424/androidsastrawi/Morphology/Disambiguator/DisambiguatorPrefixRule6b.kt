package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 6b
 * Rule 6b : terV -> te-rV
 */
class DisambiguatorPrefixRule6b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^ter([aiueo].*)$").find(word)
        if(matches != null) {
            return "r" + matches.groupValues[1]
        }
        return null
    }
}
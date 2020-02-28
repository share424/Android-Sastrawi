package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 6a
 * Rule 6a : terV -> ter-V
 * @return string
 */
class DisambiguatorPrefixRule6a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^ter([aiueo].*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1]
        }
        return null
    }
}
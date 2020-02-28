package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 11
 * Rule 11 : mem{b|f|v} -> mem-{b|f|v}
 */
class DisambiguatorPrefixRule11 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^mem([bfv])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }
}
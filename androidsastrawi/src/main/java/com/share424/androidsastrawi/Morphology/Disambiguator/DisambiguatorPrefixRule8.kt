package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 8
 * Rule 8 : terCP -> ter-CP where C != 'r' and P != 'er'
 */
class DisambiguatorPrefixRule8 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^ter([bcdfghjklmnpqrstvwxyz])(.*)$").find(word)
        if(matches != null) {
            if(matches.groupValues[1] == "r" || Regex("^er(.*)$").matches(matches.groupValues[2])) {
                return null
            }
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }
}
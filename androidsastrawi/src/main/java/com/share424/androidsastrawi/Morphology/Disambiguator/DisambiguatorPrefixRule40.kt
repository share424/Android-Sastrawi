package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 40a (CC infix rules)
 * Rule 40a : CinV -> CinV
 */
class DisambiguatorPrefixRule40a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^([bcdfghjklmnpqrstvwxyz])(in[aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 40b (CC infix rules)
 * Rule 40b : CinV -> CV
 */
class DisambiguatorPrefixRule40b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^([bcdfghjklmnpqrstvwxyz])in([aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}
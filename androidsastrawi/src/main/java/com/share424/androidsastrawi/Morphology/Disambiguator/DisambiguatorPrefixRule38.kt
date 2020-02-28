package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 38a (CC infix rules)
 * Rule 38a : CelV -> CelV
 */
class DisambiguatorPrefixRule38a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^([bcdfghjklmnpqrstvwxyz])(el[aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 38b (CC infix rules)
 * Rule 38b : CelV -> CV
 */
class DisambiguatorPrefixRule38b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^([bcdfghjklmnpqrstvwxyz])el([aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}
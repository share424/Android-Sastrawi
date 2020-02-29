package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 39a (CC infix rules)
 * Rule 39a : CemV -> CemV
 */
class DisambiguatorPrefixRule39a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^([bcdfghjklmnpqrstvwxyz])(em[aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 39b (CC infix rules)
 * Rule 39b : CemV -> CV
 */
class DisambiguatorPrefixRule39b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^([bcdfghjklmnpqrstvwxyz])em([aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}
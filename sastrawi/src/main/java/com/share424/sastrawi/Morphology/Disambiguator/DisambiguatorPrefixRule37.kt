package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 37a (CC infix rules)
 * Rule 37a : CerV -> CerV
 */
class DisambiguatorPrefixRule37a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^([bcdfghjklmnpqrstvwxyz])(er[aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 37b (CC infix rules)
 * Rule 37b : CerV -> CV
 */
class DisambiguatorPrefixRule37b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^([bcdfghjklmnpqrstvwxyz])er([aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}
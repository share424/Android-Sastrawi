package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 24
 * Rule 24 : perCAerV -> per-CAerV where C != 'r'
 */

class DisambiguatorPrefixRule24 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^per([bcdfghjklmnpqrstvwxyz])([a-z])er([aiueo])(.*)$").find(word)
        if(matches != null) {
            if(matches.groupValues[1] == "r") {
                return null
            }
            return matches.groupValues[1] + matches.groupValues[2] + "er" + matches.groupValues[3] + matches.groupValues[4]
        }
        return null
    }

}
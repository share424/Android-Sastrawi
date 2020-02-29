package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 21a
 * Rule 21a : perV -> per-V
 */
class DisambiguatorPrefixRule21a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^per([aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 21b
 * Rule 21a : perV -> pe-rV
 */
class DisambiguatorPrefixRule21b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pe(r[aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
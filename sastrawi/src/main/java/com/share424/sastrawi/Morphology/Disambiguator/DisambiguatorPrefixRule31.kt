package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 31a
 * CC Rule 31a : penyV -> pe-nyV
 */
class DisambiguatorPrefixRule31a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^peny([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "ny" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 31b
 * Original Rule 31 : penyV -> peny-sV
 * Modified by CC, shifted to 31b
 */
class DisambiguatorPrefixRule31b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^peny([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "s" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
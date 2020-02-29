package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 18a
 * CC Rule 18a : menyV -> me-nyV to stem menyala -> nyala
 */
class DisambiguatorPrefixRule18a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^meny([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "ny" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 18b
 * Original Rule 18 : menyV -> meny-sV
 * Modified by CC (shifted into 18b, see also 18a)
 */
class DisambiguatorPrefixRule18b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^meny([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "s" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
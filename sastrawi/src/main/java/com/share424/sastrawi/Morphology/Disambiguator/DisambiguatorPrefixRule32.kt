package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 32
 * Rule 32 : pelV -> pe-lV except pelajar -> ajar
 */
class DisambiguatorPrefixRule32 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        if(word == "pelajar") {
            return "ajar"
        }
        val matches = Regex("^pe(l[aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
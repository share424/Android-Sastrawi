package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 20
 * Rule 20 : pe{w|y}V -> pe-{w|y}V
 */
class DisambiguatorPrefixRule20 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pe([wy])([aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }
}
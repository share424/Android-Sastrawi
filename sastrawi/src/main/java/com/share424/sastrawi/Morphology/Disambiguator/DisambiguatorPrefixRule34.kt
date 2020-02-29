package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 34
 * Rule 34 : peCP -> pe-CP where C != {r|w|y|l|m|n} and P != 'er'
 */
class DisambiguatorPrefixRule34 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pe([bcdfghjklmnpqrstvwxyz])(.*)$").find(word)
        if(matches != null) {
            if(Regex("^er(.*)$").matches(matches.groupValues[2])) {
                return null
            }
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
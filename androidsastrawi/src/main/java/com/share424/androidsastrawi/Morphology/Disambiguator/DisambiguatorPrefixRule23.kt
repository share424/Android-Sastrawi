package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 23
 * Rule 23 : perCAP -> per-CAP where C != 'r' AND P != 'er'
 */
class DisambiguatorPrefixRule23 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^per([bcdfghjklmnpqrstvwxyz])([a-z])(.*)$").find(word)
        if(matches != null) {
            if(Regex("^er(.*)$").matches(matches.groupValues[3])) {
                return null
            }
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}
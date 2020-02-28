package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 *
 * Disambiguate Prefix Rule 2
 * Rule 2 : berCAP -> ber-CAP where C != 'r' AND P != 'er'
 */
class DisambiguatorPrefixRule2 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^ber([bcdfghjklmnpqrstvwxyz])([a-z])(.*)$").find(word)
        if(matches != null) {
            if(Regex("^er(.*)$").matches(matches.groups[3]!!.value)) {
                return null
            }
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}
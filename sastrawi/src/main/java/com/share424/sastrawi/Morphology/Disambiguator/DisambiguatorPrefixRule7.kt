package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 7
 * Rule 7 : terCerv -> ter-CerV where C != 'r'
 */
class DisambiguatorPrefixRule7 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^ter([bcdfghjklmnpqrstvwxyz])er([aiueo].*)$").find(word)
        if(matches != null) {
            if(matches.groupValues[1] == "r") {
                return null
            }
            return matches.groupValues[1] + "er" + matches.groupValues[2]
        }
        return null
    }
}
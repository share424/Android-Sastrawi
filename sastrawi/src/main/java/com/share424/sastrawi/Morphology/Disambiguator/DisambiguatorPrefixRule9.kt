package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 9
 * Rule 9 : te-C1erC2 -> te-C1erC2 where C1 != 'r'
 */
class DisambiguatorPrefixRule9 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^te([bcdfghjklmnpqrstvwxyz])er([bcdfghjklmnpqrstvwxyz])(.*)$").find(word)
        if(matches != null) {
            if(matches.groupValues[1] == "r") {
                return null
            }
            return matches.groupValues[1] + "er" + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }
}
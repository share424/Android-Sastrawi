package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 36 (CS additional rules)
 * Rule 36 : peC1erC2 -> pe-C1erC2 where C1 != {r|w|y|l|m|n}
 */
class DisambiguatorPrefixRule36 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pe([bcdfghjkpqstvxz])(er[bcdfghjklmnpqrstvwxyz])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }

}
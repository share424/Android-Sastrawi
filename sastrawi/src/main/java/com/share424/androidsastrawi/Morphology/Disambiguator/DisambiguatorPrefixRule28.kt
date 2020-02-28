package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 28a
 * Rule 28a : pen{V} -> pe-n{V}
 */
class DisambiguatorPrefixRule28a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pen([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "n" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 28b
 * Rule 28b : pen{V} -> pe-t{V}
 */
class DisambiguatorPrefixRule28b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pen([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "t" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
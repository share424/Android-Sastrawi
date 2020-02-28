package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 26a
 * Rule 26a : pem{rV|V} -> pe-m{rV|V}
 */
class DisambiguatorPrefixRule26a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pem([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "m" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 26b
 * Rule 26b : pem{rV|V} -> pe-p{rV|V}
 */
class DisambiguatorPrefixRule26b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pem([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "p" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
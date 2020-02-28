package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 13a
 * Rule 13a : mem{rV|V} -> me-m{rV|V}
 */
class DisambiguatorPrefixRule13a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^mem([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "m" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }
}

/**
 * Disambiguate Prefix Rule 13b
 * Rule 13b : mem{rV|V} -> me-p{rV|V}
 */
class DisambiguatorPrefixRule13b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^mem([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "p" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }
}
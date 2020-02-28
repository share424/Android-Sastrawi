package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 15a
 * Rule 15a : men{V} -> me-n{V}
 */
class DisambiguatorPrefixRule15a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^men([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "n" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 15b
 * Rule 15 : men{V} -> me-t{V}
 */
class DisambiguatorPrefixRule15b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^men([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "t" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }
}
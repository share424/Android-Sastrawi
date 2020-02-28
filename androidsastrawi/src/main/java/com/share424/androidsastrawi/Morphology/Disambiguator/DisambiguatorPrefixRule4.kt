package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 4
 * Rule 4 : belajar -> bel-ajar
 */
class DisambiguatorPrefixRule4 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        if(word == "belajar") {
            return "ajar"
        }
        return null
    }

}
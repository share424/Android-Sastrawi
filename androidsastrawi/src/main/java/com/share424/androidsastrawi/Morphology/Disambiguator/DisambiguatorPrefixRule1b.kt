package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 1b
 * Rule 1a : berV -> be-rV
 */
class DisambiguatorPrefixRule1b : DisambiguatorInterface {
    /**
     * Disambiguate Prefix Rule 1b
     * Rule 1b : berV -> be-rV
     * @return string
     */
    override fun disambiguate(word: String): String? {
        val matches = Regex("^ber([aiueo].*)$").find(word)
        if(matches != null) {
            return "r" + matches.groups[1]?.value
        }
        return null
    }

}
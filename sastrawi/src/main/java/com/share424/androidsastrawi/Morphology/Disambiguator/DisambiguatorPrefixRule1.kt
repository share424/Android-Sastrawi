package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Disambiguate Prefix Rule 1a
 * Rule 1a : berV -> ber-V
 */
class DisambiguatorPrefixRule1a : DisambiguatorInterface {
    /**
     * Disambiguate Prefix Rule 1a
     * Rule 1a : berV -> ber-V
     * @return string
     */
    override fun disambiguate(word: String) : String? {
        val matches = Regex("^ber([aiueo].*)$").find(word)
        if(matches != null) {
            return matches.groups[1]?.value
        }
        return null
    }
}

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
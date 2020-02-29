package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 30a
 * Rule 30a : pengV -> peng-V
 */
class DisambiguatorPrefixRule30a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^peng([aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 30b
 * Rule 30b : pengV -> peng-kV
 */
class DisambiguatorPrefixRule30b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^peng([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "k" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 30c
 * Rule 30c : pengV -> pengV- where V = 'e'
 */
class DisambiguatorPrefixRule30c : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^penge(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1]
        }
        return null
    }

}
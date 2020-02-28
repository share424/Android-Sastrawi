package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 17a
 * Rule 17a : mengV -> meng-V
 */
class DisambiguatorPrefixRule17a : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^meng([aiueo])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }
}

/**
 * Disambiguate Prefix Rule 17b
 * Rule 17b : mengV -> meng-kV
 */
class DisambiguatorprefixRule17b : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^meng([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "k" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 17c
 * Rule 17c : mengV -> mengV- where V = 'e'
 */
class DisambiguatorPrefixRule17c : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^menge(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1]
        }
        return null
    }

}

/**
 * Disambiguate Prefix Rule 17d
 * Rule 17d : mengV -> me-ngV
 */
class DisambiguatorPrefixRule17d : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^meng([aiueo])(.*)$").find(word)
        if(matches != null) {
            return "ng" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }
}
package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 5
 * Rule 5 : beC1erC2 -> be-C1erC2 where C1 != 'r'
 */
class DisambiguatorPrefixRule5 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^be([bcdfghjklmnpqstvwxyz])(er[bcdfghjklmnpqrstvwxyz])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2] + matches.groupValues[3]
        }
        return null
    }
}
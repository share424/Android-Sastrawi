package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 29
 * Original Rule 29 : peng{g|h|q} -> peng-{g|h|q}
 * Modified Rule 29 by ECS : pengC -> peng-C
 */

class DisambiguatorPrefixRule29 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^peng([bcdfghjklmnpqrstvwxyz])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
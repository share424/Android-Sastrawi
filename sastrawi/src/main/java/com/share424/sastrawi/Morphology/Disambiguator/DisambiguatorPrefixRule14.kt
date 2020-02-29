package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule no 14
 *
 * Rule 14 modified by Andy Librian : men{c|d|j|s|t|z} -> men-{c|d|j|s|t|z}
 * in order to stem mentaati
 *
 * Rule 14 modified by ECS: men{c|d|j|s|z} -> men-{c|d|j|s|z}
 * in order to stem mensyaratkan, mensyukuri
 *
 * Original CS Rule no 14 was : men{c|d|j|z} -> men-{c|d|j|z}
 */
class DisambiguatorPrefixRule14 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^men([cdjstz])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 27
 *
 * Rule 27 modified by Prasasto Adi : pen{c|d|j|s|t|z} -> pen-{c|d|j|s|t|z}
 * in order to stem penstabilan, pentranskripsi
 *
 * Original CS Rule 27 was : pen{c|d|j|z} -> pen-{c|d|j|z}
 */

class DisambiguatorPrefixRule27 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^pen([cdjstz])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 12
 * Nazief and Adriani Rule 12 : mempe{r|l} -> mem-pe{r|l}
 * Modified by Jelita Asian's CS Rule 12 : mempe -> mem-pe to stem mempengaruhi
 */
class DisambiguatorPrefixRule12 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^mempe(.*)$").find(word)
        if(matches != null) {
            return "pe" + matches.groupValues[1]
        }
        return null
    }
}
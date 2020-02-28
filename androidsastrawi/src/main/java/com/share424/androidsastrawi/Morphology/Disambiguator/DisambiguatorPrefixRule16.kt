package com.share424.androidsastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */
/**
 * Disambiguate Prefix Rule 16
 * Original Nazief and Adriani's Rule 16 : meng{g|h|q} -> meng-{g|h|q}
 * Modified Jelita Asian's CS Rule 16 : meng{g|h|q|k} -> meng-{g|h|q|k} to stem mengkritik
 */
class DisambiguatorPrefixRule16 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^meng([g|h|q|k])(.*)$").find(word)
        if(matches != null) {
            return matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
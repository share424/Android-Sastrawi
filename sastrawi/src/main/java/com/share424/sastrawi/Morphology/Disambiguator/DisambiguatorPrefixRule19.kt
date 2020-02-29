package com.share424.sastrawi.Morphology.Disambiguator

/**
 * Created by Surya Mahadi on 28/02/20.
 */

/**
 * Disambiguate Prefix Rule 19
 * Original Rule 19 : mempV -> mem-pV where V != 'e'
 * Modified Rule 19 by ECS : mempA -> mem-pA where A != 'e' in order to stem memproteksi
 */
class DisambiguatorPrefixRule19 : DisambiguatorInterface {
    override fun disambiguate(word: String): String? {
        val matches = Regex("^memp([abcdfghijklmopqrstuvwxyz])(.*)").find(word)
        if(matches != null) {
            return "p" + matches.groupValues[1] + matches.groupValues[2]
        }
        return null
    }

}
package com.share424.sastrawi.Stemmer

import com.share424.sastrawi.Dictionary.DictionaryInterface
import com.share424.sastrawi.Stemmer.Context.Context
import com.share424.sastrawi.Stemmer.Context.Visitor.VisitorProvider
import com.share424.sastrawi.Stemmer.Filter.TextNormalizer

/**
 * Created by Surya Mahadi on 29/02/20.
 */

/**
 * Indonesian Stemmer.
 * Nazief & Adriani, CS Stemmer, ECS Stemmer, Improved ECS.
 *
 * @link https://github.com/sastrawi/sastrawi/wiki/Resources
 */
class Stemmer(val dictionary : DictionaryInterface) : StemmerInterface {
    val visitorProvider = VisitorProvider()

    /**
     * Stem a text string to its common stem form.
     *
     * @param  string $text the text string to stem, e.g : memberdayakan pembangunan
     * @return string common stem form, e.g : daya bangun
     */
    override fun stem(text: String): String {
        val normalizeText = TextNormalizer.normalizeText(text)
        val words = normalizeText.split(" ")
        val stems = words.map {
            stemWord(it)
        }
        return stems.joinToString(separator = " ")
    }

    /**
     * Stem a word to its common stem form.
     *
     * @param  string $word the word to stem, e.g : memberdayakan
     * @return string common stem form, e.g : daya
     */
    private fun stemWord(word : String) : String? {
        if(isPlural(word)) {
            return stemPluralWord(word)
        } else {
            return stemSingularWord(word)
        }
    }

    /**
     * Stem a plural word to its common stem form.
     * Asian J. (2007) “Effective Techniques for Indonesian Text Retrieval” page 76-77.
     *
     * @param  string $plural the word to stem, e.g : bersama-sama
     * @return string common stem form, e.g : sama
     * @link   http://researchbank.rmit.edu.au/eserv/rmit:6312/Asian.pdf
     */
    private fun stemPluralWord(plural : String) : String? {
        val matches = Regex("^(.*)-(.*)$").find(plural) ?: return plural

        // malaikat-malaikat-nya -> malaikat malaikat-nya
        val suffix = matches.groupValues[2]
        val matches2 = Regex("^(.*)-(.*)$").find(matches.groupValues[1])
        var words1 = matches.groupValues[1]
        var words2 = matches.groupValues[2]
        if(listOf<String>("ku", "mu", "nya", "lah", "kah", "tah", "pun").contains(suffix) && matches2 != null) {
            words1 = matches2.groupValues[1]
            words2 = matches2.groupValues[2] + "-" + suffix
        }

        // berbalas-balasan -> balas
        val rootWord1 = stemSingularWord(words1)
        var rootWord2 = stemSingularWord(words2)

        // meniru-nirukan -> tiru
        if(!dictionary.contains(words2) && rootWord2 == words2) {
            rootWord2 = stemSingularWord("me" + words2)
        }

        if(rootWord1 == rootWord2) {
            return rootWord1
        } else {
            return plural
        }
    }

    /**
     * Stem a singular word to its common stem form.
     *
     * @param  string $word the word to stem, e.g : mengalahkan
     * @return string common stem form, e.g : kalah
     */
    private fun stemSingularWord(word: String) : String? {
        val context = Context(word, dictionary, visitorProvider)
        context.execute()
        return context.result
    }

    private fun isPlural(word: String): Boolean {
        // -ku|-mu|-nya
        // nikmat-Ku, etc
        val matches = Regex("^(.*)-(ku|mu|nya|lah|kah|tah|pun)$").find(word)
        if(matches != null) {
            return matches.groupValues[1].contains("-")
        }
        return word.contains("-")
    }

}
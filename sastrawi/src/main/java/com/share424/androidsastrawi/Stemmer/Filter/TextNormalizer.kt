package com.share424.androidsastrawi.Stemmer.Filter

/**
 * Created by Surya Mahadi on 29/02/20.
 */
class TextNormalizer {
    companion object {
        fun normalizeText(text : String) : String {
            var str = text.toLowerCase()
            str = Regex("[^a-z0-9 -]").replace(str, " ")
            str = Regex("( +)").replace(str, " ")
            return str.trim()
        }
    }
}
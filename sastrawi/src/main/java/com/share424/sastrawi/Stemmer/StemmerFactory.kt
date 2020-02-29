package com.share424.sastrawi.Stemmer

import android.content.Context
import com.share424.sastrawi.Dictionary.ArrayDictionary

/**
 * Created by Surya Mahadi on 29/02/20.
 */
class StemmerFactory(val context : Context) {

    fun createStemmer() : Stemmer {
        val dictionary = ArrayDictionary(getDefaultWords())
        val stemmer = Stemmer(dictionary)
        return stemmer
    }

    private fun getDefaultWords() : MutableList<String> {
        val stopWords = context.assets.open("kata_dasar.txt").bufferedReader().use {
            it.readLines()
        }

        return stopWords.toMutableList()
    }
}
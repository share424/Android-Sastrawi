package com.share424.androidsastrawi.StopWordRemover

import android.content.Context
import com.share424.androidsastrawi.Dictionary.ArrayDictionary

/**
 * Created by Surya Mahadi on 28/02/20.
 */
class StopWordRemoverFactory(val context: Context) {

    fun createStopWordRemover() : StopWordRemover {
        val dictionary = ArrayDictionary(getStopWords())
        val stopWordRemover = StopWordRemover(dictionary)
        return stopWordRemover
    }

    fun getStopWords() : MutableList<String> {
        val stopWords = context.assets.open("stop_words.txt").bufferedReader().use {
            it.readLines()
        }
        return stopWords.toMutableList()
    }
}
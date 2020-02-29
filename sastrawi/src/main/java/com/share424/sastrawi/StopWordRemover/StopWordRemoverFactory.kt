package com.share424.sastrawi.StopWordRemover

import android.content.Context
import com.share424.sastrawi.Dictionary.ArrayDictionary
import java.io.File
import java.io.FileNotFoundException

/**
 * Created by Surya Mahadi on 28/02/20.
 */
class StopWordRemoverFactory(val context: Context) {

    val stopWords = mutableListOf<String>()
    var isFromFile = false
    var isFromList = false

    fun create() : StopWordRemover {
        if(!isFromFile && !isFromList) {
            stopWords.addAll(getDefaultStopWords())
        }
        val dictionary = ArrayDictionary(stopWords)
        val stopWordRemover = StopWordRemover(dictionary)
        return stopWordRemover
    }

    fun fromFile(file : File) : StopWordRemoverFactory {
        if(file.exists()) {
            isFromFile = true
            stopWords.addAll(file.useLines { it }.toMutableList())
        } else {
            throw FileNotFoundException("File not found")
        }
        return this
    }

    fun fromList(list : List<String>) : StopWordRemoverFactory {
        isFromList = true
        stopWords.addAll(list.toMutableList())
        return this
    }

    private fun getDefaultStopWords() : MutableList<String> {
        val stopWords = context.assets.open("stop_words.txt").bufferedReader().use {
            it.readLines()
        }
        return stopWords.toMutableList()
    }
}
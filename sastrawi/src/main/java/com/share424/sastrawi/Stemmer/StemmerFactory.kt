package com.share424.sastrawi.Stemmer

import android.content.Context
import com.share424.sastrawi.Dictionary.ArrayDictionary
import java.io.File
import java.io.FileNotFoundException

/**
 * Created by Surya Mahadi on 29/02/20.
 */
class StemmerFactory(val context : Context) {

    val words = mutableListOf<String>()
    var isFromFile = false
    var isFromList = false


    fun create() : Stemmer {
        if(!isFromFile && !isFromList) {
            words.addAll(getDefaultWords())
        }
        val dictionary = ArrayDictionary(words)
        val stemmer = Stemmer(dictionary)
        return stemmer
    }

    fun fromFile(file : File) : StemmerFactory {
        if(file.exists()) {
            isFromFile = true
            words.addAll(file.useLines { it }.toMutableList())
        } else {
            throw FileNotFoundException("File not found")
        }
        return this
    }

    fun fromList(list : List<String>) : StemmerFactory {
        isFromList = true
        words.addAll(list.toMutableList())
        return this
    }

    private fun getDefaultWords() : MutableList<String> {
        val stopWords = context.assets.open("kata_dasar.txt").bufferedReader().use {
            it.readLines()
        }

        return stopWords.toMutableList()
    }
}
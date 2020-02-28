package com.share424.androidsastrawi.StopWordRemover

import com.share424.androidsastrawi.Dictionary.DictionaryInterface

/**
 * Created by Surya Mahadi on 28/02/20.
 */
class StopWordRemover(val dictionary: DictionaryInterface) {

    fun remove(text : String) : String {
        val words = text.split(" ").filter {
            !dictionary.contains(it)
        }
        return words.joinToString(separator = " ")
    }

}
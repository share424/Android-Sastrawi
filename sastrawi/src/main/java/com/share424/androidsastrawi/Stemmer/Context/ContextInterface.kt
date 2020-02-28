package com.share424.androidsastrawi.Stemmer.Context

import com.share424.androidsastrawi.Dictionary.DictionaryInterface

/**
 * Created by Surya Mahadi on 29/02/20.
 */
interface ContextInterface {
    fun getOriginalWord() : String
    fun setCurrentWord(word : String)
    fun getCurrentWord() : String
    fun getDictionary() : DictionaryInterface
    fun stopProcess()
    fun processIsStopped() : Boolean
    fun addRemoval(removal : Removal)
    fun getRemovals() : MutableList<Removal>
}
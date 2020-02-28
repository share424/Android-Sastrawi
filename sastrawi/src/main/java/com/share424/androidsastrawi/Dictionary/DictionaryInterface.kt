package com.share424.androidsastrawi.Dictionary

interface DictionaryInterface : MutableMap<String, String> {
    fun contains(word : String) : Boolean
}
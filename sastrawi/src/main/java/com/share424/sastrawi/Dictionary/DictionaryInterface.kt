package com.share424.sastrawi.Dictionary

interface DictionaryInterface : MutableMap<String, String> {
    fun contains(word : String) : Boolean
}
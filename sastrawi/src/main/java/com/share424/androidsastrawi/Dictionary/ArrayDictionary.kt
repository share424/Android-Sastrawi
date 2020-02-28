package com.share424.androidsastrawi.Dictionary

class ArrayDictionary : DictionaryInterface {
    protected val words = HashMap<String, String>()

    constructor(words : MutableList<String>) {
        if(words.isEmpty()) {
            addWords(mutableListOf())
        } else {
            addWords(words)
        }
    }

    fun addWords(words: MutableList<String>) {
        words.forEach {it ->
            add(it)
        }
    }

    fun add(word : String) {
        if(!word.trim().isBlank()) {
            words[word] = word
        }
    }

    override fun contains(word: String) : Boolean {
        return containsValue(word)
    }

    override val entries: MutableSet<MutableMap.MutableEntry<String, String>>
        get() = words.entries
    override val keys: MutableSet<String>
        get() = words.keys
    override val size: Int
        get() = words.size
    override val values: MutableCollection<String>
        get() = words.values

    override fun clear() {
        words.clear()
    }

    override fun containsKey(key: String): Boolean {
        return words.containsKey(key)
    }

    override fun containsValue(value: String): Boolean {
        return words.containsValue(value)
    }

    override fun get(key: String): String? {
        return words.get(key)
    }

    override fun isEmpty(): Boolean {
        return words.isEmpty()
    }

    override fun put(key: String, value: String): String? {
        return words.put(key, value)
    }

    override fun putAll(from: Map<out String, String>) {
        return words.putAll(from)
    }

    override fun remove(key: String): String? {
        return words.remove(key)
    }
}
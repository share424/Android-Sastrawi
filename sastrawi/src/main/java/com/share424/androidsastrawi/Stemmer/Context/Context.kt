package com.share424.androidsastrawi.Stemmer.Context

import com.share424.androidsastrawi.Dictionary.DictionaryInterface
import com.share424.androidsastrawi.Stemmer.Context.Visitor.VisitorProvider

/**
 * Created by Surya Mahadi on 29/02/20.
 */

/**
 * Stemming Context using Nazief and Adriani, CS, ECS, Improved ECS
 */
class Context(val originalWord : String, val dictionary : DictionaryInterface, val visitorProvider : VisitorProvider)  {
    var currentWord = originalWord
    val removals = mutableListOf<Removal>()

    init {
        initVisitors()
    }

    private fun initVisitors() {

    }

    fun addRemoval(removal : Removal) {
        removals.add(removal)
    }
}

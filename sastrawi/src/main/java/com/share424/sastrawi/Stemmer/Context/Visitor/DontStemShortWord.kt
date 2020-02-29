package com.share424.sastrawi.Stemmer.Context.Visitor

import com.share424.sastrawi.Stemmer.Context.Context

/**
 * Created by Surya Mahadi on 29/02/20.
 */
class DontStemShortWord : VisitorInterface {
    override fun visit(context: Context) {
        if(isShortWord(context.currentWord)) {
            context.stopProcess()
        }
    }

    protected fun isShortWord(word : String) : Boolean {
        return word.length <= 3
    }
}
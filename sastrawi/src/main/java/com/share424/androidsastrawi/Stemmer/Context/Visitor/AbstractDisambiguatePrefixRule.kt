package com.share424.androidsastrawi.Stemmer.Context.Visitor

import com.share424.androidsastrawi.Morphology.Disambiguator.DisambiguatorInterface
import com.share424.androidsastrawi.Stemmer.Context.Context
import com.share424.androidsastrawi.Stemmer.Context.Removal

/**
 * Created by Surya Mahadi on 29/02/20.
 */
abstract class AbstractDisambiguatePrefixRule : VisitorInterface {
    val disambiguators = mutableListOf<DisambiguatorInterface>()

    override fun visit(context: Context) {
        var result : String? = null
        run outer@{
            disambiguators.forEach {
                result = it.disambiguate(context.currentWord)
                if(context.dictionary.contains(result)) {
                    return@outer
                }
            }
        }
        if(result == null) {
            return
        }
        val removedPart = Regex(result.toString()).replaceFirst(context.currentWord, "")
        val removal = Removal(
            this,
            context.currentWord,
            result!!,
            removedPart,
            "DP"
        )
        context.addRemoval(removal)
        context.currentWord = result!!
    }

}
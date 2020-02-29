package com.share424.sastrawi.Stemmer.Context.Visitor

import com.share424.sastrawi.Morphology.Disambiguator.DisambiguatorInterface

/**
 * Created by Surya Mahadi on 29/02/20.
 */


class PrefixDisambiguator(val disambiguatorss : MutableList<DisambiguatorInterface>) : AbstractDisambiguatePrefixRule(), VisitorInterface {

    init {
        addDisambiguators(disambiguatorss)
    }
}
package com.share424.sastrawi.Stemmer.Context

import com.share424.sastrawi.Stemmer.Context.Visitor.VisitorInterface

/**
 * Created by Surya Mahadi on 29/02/20.
 */
class Removal(val visitor : VisitorInterface, val subject : String, val result : String, val removedPart : String, val affixType : String) {


}
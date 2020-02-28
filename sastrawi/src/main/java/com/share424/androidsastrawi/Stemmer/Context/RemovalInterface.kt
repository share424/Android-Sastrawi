package com.share424.androidsastrawi.Stemmer.Context

import com.share424.androidsastrawi.Stemmer.Context.Visitor.VisitorInterface

interface RemovalInterface {
    fun getVisitor() : VisitorInterface
    fun getSubject() : String
    fun getResult() : String
    fun getRemovedPart() : String
    fun getAffixType() : String
}

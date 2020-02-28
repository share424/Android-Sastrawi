package com.share424.androidsastrawi.Morphology

import com.share424.androidsastrawi.Specification.SpecificationInterface

class InvalidAffixPairSpecification : SpecificationInterface {
    override fun isSatisfiedBy(word: String): Boolean {
        if(Regex("^me(.*)kan$").matches(word)) {
            return false
        }

        if(word == "ketahui") {
            return false
        }

        val invalidAffixes = listOf(
            "^ber(.*)i$",
            "^di(.*)an$",
            "^ke(.*)i$",
            "^ke(.*)an$",
            "^me(.*)an$",
            "^me(.*)an$",
            "^ter(.*)an$",
            "^per(.*)an$"
        )

        invalidAffixes.forEach {invalidAffix ->
            if(Regex(invalidAffix).matches(word)) return true
        }

        return false
    }
}
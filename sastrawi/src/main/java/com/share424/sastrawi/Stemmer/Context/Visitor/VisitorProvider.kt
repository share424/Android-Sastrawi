package com.share424.sastrawi.Stemmer.Context.Visitor

import com.share424.sastrawi.Morphology.Disambiguator.DisambiguatorInterface
import com.share424.sastrawi.Morphology.Disambiguator.*

/**
 * Created by Surya Mahadi on 29/02/20.
 */
class VisitorProvider {
    val visitors = mutableListOf<VisitorInterface>()
    val suffixVisitors = mutableListOf<VisitorInterface>()
    val prefixVisitors = mutableListOf<VisitorInterface>()

    init {
        initVisitors()
    }

    private fun initVisitors() {
        visitors.add(DontStemShortWord())

        // {lah|kah|tah|pun}
        suffixVisitors.add(RemoveInflectionalParticle())
        // ku|mu|nya}
        suffixVisitors.add(RemoveInflectionalPossessivePronoun())
        // {i|kan|an}
        suffixVisitors.add(RemoveDerivationalSuffix())

        //{di|ke|se}
        prefixVisitors.add(RemovePlainPrefix())

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(
            DisambiguatorPrefixRule1a(),
            DisambiguatorPrefixRule1b()
        ).toMutableList()))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule2()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule3()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule4()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule5()).toMutableList()))


        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(
            DisambiguatorPrefixRule6a(),
            DisambiguatorPrefixRule6b()
        ).toMutableList()))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule7()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule8()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule9()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule10()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule11()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule12()).toMutableList()))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule13a(),
                DisambiguatorPrefixRule13b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule14()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule15a(),
                DisambiguatorPrefixRule15b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule16()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule17a(),
                DisambiguatorPrefixRule17b(),
                DisambiguatorPrefixRule17c(),
                DisambiguatorPrefixRule17d()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule18a(),
                DisambiguatorPrefixRule18b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule19()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule20()).toMutableList()))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule21a(),
                DisambiguatorPrefixRule21b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule23()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule24()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule25()).toMutableList()))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule26a(),
                DisambiguatorPrefixRule26b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule27()).toMutableList()))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule28a(),
                DisambiguatorPrefixRule28b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule29()).toMutableList()))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule30a(),
                DisambiguatorPrefixRule30b(),
                DisambiguatorPrefixRule30c()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule31a(),
                DisambiguatorPrefixRule31b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule32()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule34()).toMutableList()))

        // CS additional rules
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule35()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule36()).toMutableList()))

        // CC infix rules
        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule37a(),
                DisambiguatorPrefixRule37b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule38a(),
                DisambiguatorPrefixRule38b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule39a(),
                DisambiguatorPrefixRule39b()
            ).toMutableList()
        ))

        prefixVisitors.add(PrefixDisambiguator(
            listOf<DisambiguatorInterface>(
                DisambiguatorPrefixRule40a(),
                DisambiguatorPrefixRule40b()
            ).toMutableList()
        ))

        // Sastrawi rules
        // ku-A, kau-A
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule41()).toMutableList()))
        prefixVisitors.add(PrefixDisambiguator(listOf<DisambiguatorInterface>(DisambiguatorPrefixRule42()).toMutableList()))

    }
}
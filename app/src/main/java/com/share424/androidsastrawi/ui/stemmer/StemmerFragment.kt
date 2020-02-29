package com.share424.androidsastrawi.ui.stemmer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.share424.androidsastrawi.R
import com.share424.sastrawi.Stemmer.StemmerFactory
import kotlinx.android.synthetic.main.fragment_stemmer.view.*

/**
 * Created by Surya Mahadi on 29/02/20.
 */
class StemmerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_stemmer, container, false)
        val stemmer = StemmerFactory(context!!).create()
        root.btn_stem.setOnClickListener {
            val output = stemmer.stem(root.txt_input.text.toString())
            root.txt_output.setText(output)
        }
        return root
    }
}
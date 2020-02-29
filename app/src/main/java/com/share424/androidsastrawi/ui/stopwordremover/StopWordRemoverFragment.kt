package com.share424.androidsastrawi.ui.stopwordremover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.share424.androidsastrawi.R
import com.share424.sastrawi.StopWordRemover.StopWordRemoverFactory
import kotlinx.android.synthetic.main.fragment_stemmer.view.*
import kotlinx.android.synthetic.main.fragment_stemmer.view.txt_input
import kotlinx.android.synthetic.main.fragment_stemmer.view.txt_output
import kotlinx.android.synthetic.main.fragment_stop_word_remover.view.*
import java.io.File

/**
 * Created by Surya Mahadi on 29/02/20.
 */

class StopWordRemoverFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_stop_word_remover, container, false)
        val stopWordRemover = StopWordRemoverFactory(context!!).create()
        root.btn_stop_word.setOnClickListener {
            val output = stopWordRemover.remove(root.txt_input.text.toString())
            root.txt_output.setText(output)
        }
        return root
    }
}
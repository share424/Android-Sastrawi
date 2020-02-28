package com.share424.androidsastrawi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.share424.androidsastrawi.StopWordRemover.StopWordRemoverFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stopWordremover = StopWordRemoverFactory(this).createStopWordRemover()

        btn_stem.setOnClickListener {
            val output = stopWordremover.remove(txt_input.text.toString())
            txt_output.setText(output)
        }


    }
}

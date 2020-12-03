package com.unicesumar.esoft.monitoraagricultor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_intro_um.*

class IntroUmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_um)

        button.setOnClickListener() {
            mudarParaActivity()
        }
    }

    private fun mudarParaActivity() {
        val intent = Intent(this, IntroDoisActivity::class.java)
        startActivity(intent)
    }

}
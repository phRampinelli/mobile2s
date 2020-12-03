package com.unicesumar.esoft.monitoraagricultor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro_dois.*
import kotlinx.android.synthetic.main.activity_intro_um.*

class IntroDoisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_dois)

        buttonNext.setOnClickListener() {
            val intent = Intent(this, DuvidaActivity::class.java)
            startActivity(intent)
        }

        buttonPreview.setOnClickListener() {
            val intent = Intent(this, IntroUmActivity::class.java)
            startActivity(intent)
        }
    }
}
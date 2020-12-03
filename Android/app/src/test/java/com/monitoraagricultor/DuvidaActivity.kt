package com.unicesumar.esoft.monitoraagricultor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.jetbrains.anko.db.insert

class DuvidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_duvida)

        val textoDuvida = findViewById<EditText>(R.id.duvida)

        val botaoConsultar = findViewById<Button>(R.id.consultar)

        botaoConsultar.setOnClickListener {
            database.use{
                val idDuvida = insert("duvida",
                    "duvida" to textoDuvida.text.toString()
                )
                if (idDuvida != -1L) {
                    toast("Consultando...\n$idDuvida: ${textoDuvida.text.toString()}")
                    textoDuvida.text.clear()
                    listaDuvidas()
                } else {
                    toast("Erro ao inserir no banco de dados")
                }
            }
        }
    }

    private fun listaDuvidas() {
        val intent = Intent(this, ListaDuvidaActivity::class.java)
        startActivity(intent)
    }

    private fun toast(mensagem: String) {
        Toast.makeText(applicationContext,mensagem,Toast.LENGTH_LONG).show()
    }
}
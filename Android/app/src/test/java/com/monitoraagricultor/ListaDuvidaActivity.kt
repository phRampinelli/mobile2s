package com.unicesumar.esoft.monitoraagricultor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_duvida.*
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.rowParser
import org.jetbrains.anko.db.select

class ListaDuvidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_duvida)

        val duvidasAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        list_view_duvidas.adapter = duvidasAdapter

        duvidasAdapter.add("Item 1")
        duvidasAdapter.add("Item 2")

        database.use {
            select("duvida").exec {
                val parser = rowParser() { id: Int,
                                           duvida: String ->
                    Duvida(id, duvida)
                }
                var listaDuvidas = parseList(parser)

                duvidasAdapter.clear()
                val duvidasTexto = listaDuvidas.map { it.duvida }
                duvidasAdapter.addAll(duvidasTexto)
            }
        }

        list_view_duvidas.setOnItemClickListener { parent, view, position, id ->
            Log.d("Debug", "${position}, ${id}")

            val intent = Intent(this, LocalizacaoActivity::class.java)
            startActivity(intent)

//            val intent = Intent(this, CarregaFotoActivity::class.java)
//            startActivity(intent)
        }

    }
}
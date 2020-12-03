package com.unicesumar.esoft.listacontatos

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buscaContatos()
    }

    fun buscaContatos() {
        var cursor: Cursor? = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null, null)

        startManagingCursor(cursor)

        var from = arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID)

        var to = intArrayOf(android.R.id.text1, android.R.id.text2)

        var simple: SimpleCursorAdapter = SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,
                cursor, from, to)

        contatos.adapter = simple
    }
}
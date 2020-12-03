package com.unicesumar.esoft.monitoraagricultor

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MonitoraDatabase(contex: Context) :
    ManagedSQLiteOpenHelper(ctx = contex, name = "monitora.db", version = 1) {

    companion object {
        private var instance: MonitoraDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): MonitoraDatabase {
            if (instance == null) {
                instance = MonitoraDatabase(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("duvida", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "duvida" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}

val Context.database: MonitoraDatabase
    get() = MonitoraDatabase.getInstance(getApplicationContext())
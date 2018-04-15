package com.example.jesus.jeferson.sqlite

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val bancoDeDados: SQLiteDatabase = openOrCreateDatabase("appDb" , Context.MODE_PRIVATE , null)

            //criando tabela
            //bancoDeDados.execSQL("DROP TABLE pessoas")
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3))")
            //Inserindo dados


            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Carlos' , 18)")
            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Luiza' , 15)")
            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Carlos' , 18)")
            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Jeferson' , 40)")
            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Pedro' , 25)")
            bancoDeDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('João' , 32)")



            val cursor = bancoDeDados.rawQuery("SELECT id,nome, idade FROM pessoas WHERE idade > 20" , null)

            val indiceid = cursor.getColumnIndex("id")
            val indiceNome = cursor.getColumnIndex("nome")
            val indiceIdade = cursor.getColumnIndex("idade")

            cursor.moveToFirst()

            while (cursor != null) {
                Log.i("Resultado - ID: ", cursor.getString(indiceid))
                Log.i("Resultado - Nome: ", cursor.getString(indiceNome))
                Log.i("Resultado - Idade: ", cursor.getString(indiceIdade))
                cursor.moveToNext()
            }

        } catch (ex : Exception) {
            ex.printStackTrace()
        }




    }
}

package com.example.jesus.jeferson.listadetarefas.model.repository

import android.content.ContentValues
import android.content.Context
import android.support.v7.widget.ThemedSpinnerAdapter
import android.util.Log
import com.example.jesus.jeferson.listadetarefas.model.entity.Tarefa
import com.example.jesus.jeferson.listadetarefas.model.repository.base.DbTarefasOpenHelper

/**
 * Created by jeferson.jesus on 11/04/18.
 */
class TarefaRepository {

    private var dbHelper: DbTarefasOpenHelper

    constructor(context: Context) {
        dbHelper = DbTarefasOpenHelper(context)
    }

    public fun listarTodos() : MutableList<Tarefa> {

        val retorno = ArrayList<Tarefa>(0)

        val db = dbHelper.readableDatabase

        val cursor = db.rawQuery("SELECT * FROM ${DbTarefasOpenHelper.TABELA_TAREFA}" , null)

        val indiceid = cursor.getColumnIndex(DbTarefasOpenHelper.ID)
        val indiceNome = cursor.getColumnIndex(DbTarefasOpenHelper.NOME)

        cursor.moveToFirst()
        if (cursor.count > 0) {
            while (cursor != null) {
                retorno.add(Tarefa(cursor.getInt(indiceid).toLong(), cursor.getString(indiceNome)))
                cursor.moveToNext()
            }
        }

        return retorno
    }

    public fun inserir(tarefa: Tarefa)  {
        var valores: ContentValues = ContentValues()

        val db = dbHelper.writableDatabase

        valores.put(DbTarefasOpenHelper.NOME, tarefa.nome)

        db.insert(DbTarefasOpenHelper.TABELA_TAREFA, null, valores)

        db.close()
    }

    public fun alterar(tarefa: Tarefa)  {

    }

    public fun excluir(tarefa: Tarefa)  {

    }
}
package com.example.jesus.jeferson.listadetarefas.model.repository.base

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by jeferson.jesus on 12/04/18
 */
class DbTarefasOpenHelper(context: Context?) : SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO_DB) {

    companion object {
        private val NOME_BANCO = "bancotarefas.db"
        val TABELA_TAREFA = "tarefas"
        val ID = "_id"
        val NOME = "nome"
        val DATA_INICIO = "data_inicio"
        val DATA_FIM = "data_fim"
        private val VERSAO_DB = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE ${TABELA_TAREFA} ( " +
                "${ID} integer PRIMARY KEY AUTOINCREMENT, " +
                "${NOME} text not null, " +
                "${DATA_INICIO} date, " +
                "${DATA_FIM} date);"

        db?.let {
            it.execSQL(sql)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
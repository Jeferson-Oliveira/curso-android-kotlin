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
        private val VERSAO_DB = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE IF NOT EXISTS ${TABELA_TAREFA} ( " +
                "${ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${NOME} VARCHAR NOT NULL); "
        db?.let {
            it.execSQL(sql)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
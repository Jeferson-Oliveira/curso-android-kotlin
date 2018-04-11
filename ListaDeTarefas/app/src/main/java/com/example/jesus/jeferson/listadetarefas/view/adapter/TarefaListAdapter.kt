package com.example.jesus.jeferson.listadetarefas.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jesus.jeferson.listadetarefas.R
import com.example.jesus.jeferson.listadetarefas.model.entity.Tarefa
import com.example.jesus.jeferson.listadetarefas.view.viewholder.TarefaViewHolder

/**
 * Created by jeferson.jesus on 11/04/18.
 */
class TarefaListAdapter : RecyclerView.Adapter<TarefaViewHolder> {

    private var context: Context
    private var tarefas: List<Tarefa>

    constructor(tarefas: List<Tarefa>, context: Context) {
        this.tarefas = tarefas
        this.context = context
    }

    override fun getItemCount(): Int {
        return tarefas.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.tarefa_item, parent,false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder?, position: Int) {
        val tarefa = this.tarefas.get(position)
        holder?.let {
            it.bidingView(tarefa)
        }
    }


}
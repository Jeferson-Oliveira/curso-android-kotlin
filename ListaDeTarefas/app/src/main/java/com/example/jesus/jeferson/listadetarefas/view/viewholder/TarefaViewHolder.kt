package com.example.jesus.jeferson.listadetarefas.view.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.jesus.jeferson.listadetarefas.model.entity.Tarefa
import kotlinx.android.synthetic.main.tarefa_item.view.*

/**
 * Created by jeferson.jesus on 11/04/18.
 */
class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nome = itemView.txNomeTarefa

    fun bidingView(tarefa: Tarefa) {
        this.nome.text = tarefa.nome

    }
}
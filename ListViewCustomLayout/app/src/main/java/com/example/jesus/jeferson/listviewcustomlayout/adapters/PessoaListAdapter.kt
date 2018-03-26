package com.example.jesus.jeferson.listviewcustomlayout.adapters

import android.app.Activity
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.jesus.jeferson.listviewcustomlayout.R
import com.example.jesus.jeferson.listviewcustomlayout.model.entity.Pessoa
import kotlinx.android.synthetic.main.pessoarow.view.*

/**
 * Created by jeferson.jesus on 26/03/18.
 */
class PessoaListAdapter : BaseAdapter {

    private var activity: Activity
    private var pessoas : List<Pessoa> = emptyList()

    constructor(pessoas: List<Pessoa>, act : Activity ) {
        this.pessoas = pessoas
        this.activity = act
    }

    override fun getCount(): Int {
        return pessoas.count()
    }

    override fun getItem(position: Int): Pessoa {
        return pessoas.get(position)
    }

    override fun getItemId(position: Int): Long {
        return pessoas.get(position).id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // 1 - layout , 2 - group , 3 - criar view no momento (false = passar dados antes de instanciar)
        val view = activity.layoutInflater.inflate(R.layout.pessoarow,parent,false)
        val model = pessoas.get(position)

        view.imgSexo.setImageResource(model.sexo.getIcon())
        view.txtNome.text = model.nome
        view.txtSobrenome.text = model.sobrenome
        view.txtDatanascimento.text = model.dataNascimento
        return view
    }

}
package com.example.jesus.jeferson.listviewcustomlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.jesus.jeferson.listviewcustomlayout.adapters.PessoaListAdapter
import com.example.jesus.jeferson.listviewcustomlayout.model.entity.Pessoa
import com.example.jesus.jeferson.listviewcustomlayout.model.service.PessoaRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.coroutines.experimental.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {

    private val service = PessoaRepository()
    private var pessoasList: List<Pessoa> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadComponents()

        loadPessoas()
    }


    private fun loadComponents() {
        listaItens.setOnItemClickListener{ parent, view, position,id ->
            Toast.makeText(applicationContext,"Item Selecionado - ${pessoasList.get(position).nome}",Toast.LENGTH_SHORT).show()
        }
        button.setOnClickListener {
            loadPessoas()
        }
    }

    private fun loadPessoas() {
        service.listar(onSucess = { pessoas ->
            pessoas?.let {
                this.pessoasList = it
                listaItens.adapter = PessoaListAdapter(it, this) //ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pessoasList.map { it.nome })  // PessoaListAdapter(pessoasList,this)
            }
        } , onError = { mensagem ->
            mensagem?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }

}

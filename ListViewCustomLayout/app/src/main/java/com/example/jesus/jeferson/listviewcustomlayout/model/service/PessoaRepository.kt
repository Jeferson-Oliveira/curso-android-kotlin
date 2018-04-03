package com.example.jesus.jeferson.listviewcustomlayout.model.service

import com.example.jesus.jeferson.listviewcustomlayout.model.entity.Pessoa
import com.example.jesus.jeferson.listviewcustomlayout.model.entity.SexoEnum
import com.example.jesus.jeferson.listviewcustomlayout.model.service.interfaces.IPessoaRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by jeferson.jesus on 26/03/18.
 */
class PessoaRepository  {

    val retrofitConfig = RetrofitConfig()

    fun listar(onSucess: (pessoas: List<Pessoa>?) -> Unit , onError: (String?) -> Unit) : Unit {
        val call = retrofitConfig.pessoaRepository().listar()

        call.enqueue(object: Callback<List<Pessoa>?> {
            override fun onResponse(call: Call<List<Pessoa>?>?,
                                    response: Response<List<Pessoa>?>?) {
                response?.body()?.let {
                    onSucess(it)
                }
            }

            override fun onFailure(call: Call<List<Pessoa>?>?,
                                   t: Throwable?) {
                onError(t?.message)
            }
        })
    }

    public fun getPessoas() : List<Pessoa> {
        var pessoas = ArrayList<Pessoa>()
        for (i in 1..9) {
            val randomSexo =  if (Random().nextInt(2) == 1)  SexoEnum.MASCULINO else SexoEnum.FEMININO
            pessoas.add(Pessoa(i.toLong() ,"Pessoa - ${i}", "Sobrenome - ${i}","0${i}/05/199${i}", randomSexo))
        }
        return pessoas
    }
}
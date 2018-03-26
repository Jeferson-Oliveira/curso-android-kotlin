package com.example.jesus.jeferson.listviewcustomlayout.model.service

import com.example.jesus.jeferson.listviewcustomlayout.model.entity.Pessoa
import com.example.jesus.jeferson.listviewcustomlayout.model.entity.SexoEnum
import java.util.*

/**
 * Created by jeferson.jesus on 26/03/18.
 */
class PessoaRepository {

    public fun getPessoas() : List<Pessoa> {
        var pessoas = ArrayList<Pessoa>()
        for (i in 1..9) {
            val randomSexo =  if (Random().nextInt(2) == 1)  SexoEnum.MASCULINO else SexoEnum.FEMININO
            pessoas.add(Pessoa(i.toLong() ,"Pessoa - ${i}", "Sobrenome - ${i}","0${i}/05/199${i}", randomSexo))
        }
        return pessoas
    }
}
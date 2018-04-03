package com.example.jesus.jeferson.listviewcustomlayout.model.service.interfaces

import com.example.jesus.jeferson.listviewcustomlayout.model.entity.Pessoa
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by jeferson on 02/04/18.
 */
interface IPessoaRepository {

    @GET("pessoa")
    public fun listar() : Call<List<Pessoa>>
}
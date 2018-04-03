package com.example.jesus.jeferson.listviewcustomlayout.model.service

import com.example.jesus.jeferson.listviewcustomlayout.model.service.interfaces.IPessoaRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jeferson on 02/04/18.
 */
class RetrofitConfig {
    private val retrofit = Retrofit.Builder().baseUrl("http://testearquitetura.herokuapp.com/api/").addConverterFactory(GsonConverterFactory.create()).build()


    public fun pessoaRepository() : IPessoaRepository {
        return retrofit.create(IPessoaRepository::class.java)
    }
}
package com.example.jesus.jeferson.listviewcustomlayout.model.entity

import com.example.jesus.jeferson.listviewcustomlayout.R

/**
 * Created by jeferson.jesus on 26/03/18.
 */
enum class SexoEnum  {

    MASCULINO, FEMININO;

    public fun getIcon() : Int {
        when(this) {
            SexoEnum.FEMININO -> return R.drawable.if_user_female
            SexoEnum.MASCULINO -> return R.drawable.if_user_male
        }
    }
}
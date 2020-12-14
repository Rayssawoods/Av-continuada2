package br.com.bandtec.fragmentado

import java.io.Serializable

data class Cadastro (
    val usuario:String,
    val idade:Int,
    val peso:Double,
    val aprovado:Boolean
) : Serializable
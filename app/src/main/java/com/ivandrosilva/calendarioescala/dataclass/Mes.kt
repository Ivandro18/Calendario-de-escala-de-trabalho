package com.ivandrosilva.calendarioescala.dataclass


data class Mes (val nMes: Int, val mesAno: String){
    val dias = mutableListOf<Dia>()


    fun addDia(dia: Dia){
        dias.add(dia)
    }

}
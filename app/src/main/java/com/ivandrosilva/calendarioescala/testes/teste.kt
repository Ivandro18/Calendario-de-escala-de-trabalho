package com.ivandrosilva.calendarioescala.testes

import com.ivandrosilva.calendarioescala.services.CalendarioService

fun main(){
    val lista = CalendarioService(2023,1).getLista()
    lista.forEach { mes ->
        println(mes.mesAno)
        mes.dias.forEach{
            print(" ${it.dia}")
        }
        println()
    }
}
package com.ivandrosilva.calendarioescala.services

import com.ivandrosilva.calendarioescala.dataclass.Dia
import com.ivandrosilva.calendarioescala.dataclass.Mes
import java.time.LocalDate

class CalendarioService {
    val listaMeses = mutableListOf<Mes>()
    var contadorMes = 0
    var anoInicial = 2022
    val mapCalendario: MutableMap<LocalDate, Dia> = mutableMapOf() // para mapear os dias do calendario, pra ficar mais facil achar para adicionar os eventos
    var dataMapa = LocalDate.now()
    constructor(currentYear: Int, numberOfYears: Int){

        anoInicial = currentYear

        for (year in currentYear until currentYear + numberOfYears) {
            for (month in 1..12) {
                monthCalendar(year, month)
            }
            println()
        }
    }
    private fun monthCalendar(year: Int, month: Int){
        val firstDayOfMonth = LocalDate.of(year, month, 1)
        val numberOfDaysInMonth = firstDayOfMonth.lengthOfMonth()
        val dayOfWeek = firstDayOfMonth.dayOfWeek.value
        val mes = Mes(contadorMes, getMonthName(month) + " de " + year.toString())

        // Adicionando espaço vazio para os primeiros dias
        for (i in 1 until dayOfWeek) {
            mes.addDia(Dia("",null))
        }


        for (day in 1..numberOfDaysInMonth) {
            val dia = Dia(day.toString(),dataMapa)
            mes.addDia(dia)
            mapCalendario[dataMapa] = dia
        }
        listaMeses.add(mes)

    }

    private fun getMonthName(month: Int): String {
        return when (month) {
            1 -> "Janeiro"
            2 -> "Fevereiro"
            3 -> "Março"
            4 -> "Abril"
            5 -> "Maio"
            6 -> "Junho"
            7 -> "Julho"
            8 -> "Agosto"
            9 -> "Setembro"
            10 -> "Outubro"
            11 -> "Novembro"
            12 -> "Dezembro"
            else -> ""
        }
    }
    fun getMesAtual(): Int {// retorna a quantidades de meses que ja passou desde o start do calendario para centralizar o mesmo no mesmo atual
        val data = LocalDate.now()
        return (data.year - anoInicial) * 12 + data.monthValue - 1
    }
    fun getLista(): MutableList<Mes> {
        return listaMeses
    }
}
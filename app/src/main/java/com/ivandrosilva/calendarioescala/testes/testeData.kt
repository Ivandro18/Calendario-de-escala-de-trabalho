package com.ivandrosilva.calendarioescala.testes

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    // Obtendo a data atual
    val currentDate = LocalDate.now()
    println("Data Atual: $currentDate")

    // Criando uma data específica
    val specificDate = LocalDate.of(2023, 5, 15)
    println("Data Específica: $specificDate")

    // Adicionando e subtraindo dias
    val futureDate = currentDate.plusDays(7)
    val pastDate = currentDate.minusDays(7)
    println("Data Atual + 7 dias: $futureDate")
    println("Data Atual - 7 dias: $pastDate")

    // Comparando datas
    val isAfter = specificDate.isAfter(currentDate)
    val isBefore = specificDate.isBefore(currentDate)
    val isEqual = specificDate.isEqual(currentDate)
    println("É depois da data atual? $isAfter")
    println("É antes da data atual? $isBefore")
    println("É igual à data atual? $isEqual")

    // Formatando datas
    val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    println("Data Atual Formatada: $formattedDate")

    // Obtendo componentes individuais
    val dayOfMonth = currentDate.dayOfMonth
    val month = currentDate.month
    val year = currentDate.year
    println("Dia do Mês: $dayOfMonth, Mês: $month, Ano: $year")

    var currentDate2 = LocalDate.now()
    for(i in 1..40 ){
        currentDate2 = currentDate2.plusDays(1)
        println(currentDate2)
    }
}
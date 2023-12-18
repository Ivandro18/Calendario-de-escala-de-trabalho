package com.ivandrosilva.calendarioescala.testes
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
fun main(){
    // Mês e ano para o qual queremos criar o calendário
    val year = 2024
    val month = 1

    // Obtendo o primeiro dia do mês
    val firstDayOfMonth = LocalDate.of(year, month, 1)

    // Obtendo o número de dias no mês
    val numberOfDaysInMonth = firstDayOfMonth.lengthOfMonth()

    // Obtendo o dia da semana do primeiro dia do mês
    val dayOfWeek = firstDayOfMonth.dayOfWeek.value

    // Imprimindo o cabeçalho do calendário
    println("Dom Seg Ter Qua Qui Sex Sab")

    // Imprimindo espaços para o primeiro dia
    for (i in 1 until dayOfWeek) {
        print("    ")
    }

    // Imprimindo os dias do mês
    for (day in 1..numberOfDaysInMonth) {
        print("%3d ".format(day))

        // Quebrando a linha no sábado
        if ((day + dayOfWeek - 1) % 7 == 0) {
            println()
        }
    }
    println()


}
package com.ivandrosilva.calendarioescala.testes
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val currentYear = LocalDate.now().year
    val numberOfYears = 2

    for (year in currentYear until currentYear + numberOfYears) {
        println("Calendário para o ano $year:")
        for (month in 1..12) {
            println(getMonthCalendar(year, month))
        }
        println()
    }
}

fun getMonthCalendar(year: Int, month: Int): String {
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val numberOfDaysInMonth = firstDayOfMonth.lengthOfMonth()
    val dayOfWeek = firstDayOfMonth.dayOfWeek.value

    val header = "  Su Mo Tu We Th Fr Sa"
    val prefix = " ".repeat((dayOfWeek - 1) * 3)

    val days = (1..numberOfDaysInMonth).joinToString(" ") {
        "%2d".format(it)
    }

    return buildString {
        appendln("${getMonthName(month)} $year")
        appendln(header)
        appendln(prefix + days)
        appendln()
    }
}

fun getMonthName(month: Int): String {
    return LocalDate.of(1, month, 1)
        .format(DateTimeFormatter.ofPattern("MMMM"))
}


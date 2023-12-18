package com.ivandrosilva.calendarioescala.testes
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    // Criando um Map para representar o calendário de eventos
    val eventCalendar: MutableMap<LocalDate, List<String>> = mutableMapOf()

    // Adicionando eventos ao calendário
    eventCalendar[LocalDate.of(2023, 1, 15)] = listOf("Aniversário de Alice", "Reunião de Equipe")
    eventCalendar[LocalDate.of(2023, 2, 10)] = listOf("Apresentação do Projeto")
    eventCalendar[LocalDate.of(2023, 3, 5)] = listOf("Conferência")
    eventCalendar[LocalDate.of(2023, 4, 20)] = listOf("Aniversário de Bob", "Entrega do Relatório")

    // Exibindo o calendário de eventos
    for ((date, events) in eventCalendar) {
        println("${date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}:")
        for (event in events) {
            println("  - $event")
        }
        println()
    }
}

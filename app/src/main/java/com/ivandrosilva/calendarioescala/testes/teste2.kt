package com.ivandrosilva.calendarioescala.testes

data class Person(var name: String)

fun main() {
    // Criando uma instância de Person
    var person1 = Person("Alice")

    // Copiando a referência para a variável person2
    var person2 = person1

    // Modificando o nome da pessoa através de person2
    person2.name = "Bob"

    // Imprimindo as informações de ambas as variáveis
    println("Person1: ${person1.name}")
    println("Person2: ${person2.name}")
}
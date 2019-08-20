package com.thalles.firstmvvm.data

class NotaManager {

    private val data = listOf(
        Nota(texto = "Nota 1"),
        Nota(texto = "Nota 2"),
        Nota(texto = "Nota 3"),
        Nota(texto = "Nota 4")
    )

    fun getNotas() = data
}
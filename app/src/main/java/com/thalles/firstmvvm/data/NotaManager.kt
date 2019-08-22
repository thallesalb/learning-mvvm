package com.thalles.firstmvvm.data

class NotaManager(private val database: Database) {
    fun getNotas() = database.obterNotas()
    fun addNota(nota: Nota) = database.inserir(nota)
}
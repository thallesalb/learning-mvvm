package com.thalles.firstmvvm.data

import androidx.lifecycle.MutableLiveData

class NotaManager {

    private val data: MutableLiveData<MutableList<Nota>> = MutableLiveData()


    fun getNotas() = data
    fun addNota(nota: Nota) {
        data.postValue(
            data.value?.let {
                it.add(nota)
                it
            } ?: mutableListOf(nota)
        )
    }
}
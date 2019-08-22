package com.thalles.firstmvvm.data

import androidx.lifecycle.MutableLiveData

class Database {

    private val mDataBase: MutableLiveData<MutableList<Nota>> = MutableLiveData()

    fun inserir(nota: Nota) {
        mDataBase.postValue(
            mDataBase.value?.let {
                it.add(nota)
                it
            } ?: mutableListOf(nota)
        )
    }

    fun obterNotas() = mDataBase
}
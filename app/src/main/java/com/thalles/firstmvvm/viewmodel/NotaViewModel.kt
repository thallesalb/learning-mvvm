package com.thalles.firstmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thalles.firstmvvm.data.Nota
import com.thalles.firstmvvm.data.NotaManager

class NotaViewModel: ViewModel() {
    private val manager = NotaManager()
    private lateinit var mNotas: MutableLiveData<List<Nota>>

    fun getNotas(): MutableLiveData<List<Nota>> {
        if (!::mNotas.isInitialized) {
            loadNotas()
        }

        return mNotas
    }

    fun loadNotas() {
        if (!::mNotas.isInitialized) {
            mNotas = MutableLiveData()
        }

        val tmp = manager.getNotas()
        mNotas.postValue(tmp)
    }
}
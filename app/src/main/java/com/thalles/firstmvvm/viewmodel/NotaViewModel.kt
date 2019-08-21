package com.thalles.firstmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thalles.firstmvvm.data.Nota
import com.thalles.firstmvvm.data.NotaManager

class NotaViewModel: ViewModel() {
    private val manager = NotaManager()
    private lateinit var mNotas: MutableLiveData<MutableList<Nota>>

    fun getNotas(): MutableLiveData<MutableList<Nota>> {
        if (!::mNotas.isInitialized)
            mNotas = manager.getNotas()

        return mNotas
    }

    fun save(nota: Nota) = manager.addNota(nota)
}
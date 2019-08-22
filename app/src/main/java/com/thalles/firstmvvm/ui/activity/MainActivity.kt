package com.thalles.firstmvvm.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.thalles.firstmvvm.R
import com.thalles.firstmvvm.data.Nota
import com.thalles.firstmvvm.ui.adapter.NotasAdapter
import com.thalles.firstmvvm.viewmodel.NotaViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_nota.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    // Iniciando ViewModel padrão Koin
    private val notaViewModel: NotaViewModel by viewModel()
    private val notasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        recyclerView.apply {
            adapter = notasAdapter
        }

        // Iniciando ViewModel padrão Android
//        notaViewModel = ViewModelProviders.of(this).get(NotaViewModel::class.java)
        notaViewModel.getNotas().observe(this, Observer { data ->
            data?.let {
                notasAdapter.add(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_add) {
            dialogAddNota().show()
        }

        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("InflateParams")
    private fun dialogAddNota(): AlertDialog {
        val layout = layoutInflater.inflate(R.layout.dialog_add_nota, null, false)

        return AlertDialog.Builder(this).apply {
            setView(layout)
            setNegativeButton("Cancelar", null)
            setPositiveButton("Salvar") { dialog, _ ->
                notaViewModel.save(Nota(texto = layout.edtInputNota.text.toString()))
                dialog.dismiss()
            }
        }.create()
    }

}

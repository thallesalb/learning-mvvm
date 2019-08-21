package com.thalles.firstmvvm.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.thalles.firstmvvm.R
import com.thalles.firstmvvm.ui.adapter.NotasAdapter
import com.thalles.firstmvvm.viewmodel.NotaViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var notaViewModel: NotaViewModel
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

        notaViewModel = ViewModelProviders.of(this).get(NotaViewModel::class.java)
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

        }

        return super.onOptionsItemSelected(item)
    }

}

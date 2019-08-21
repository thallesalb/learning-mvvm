package com.thalles.firstmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thalles.firstmvvm.R
import com.thalles.firstmvvm.data.Nota
import kotlinx.android.synthetic.main.item_nota.view.*

class NotasAdapter(private val data: MutableList<Nota> = mutableListOf())
    : RecyclerView.Adapter<NotasAdapter.NotasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        return NotasViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_nota, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) =
        holder.bind(data[position])

    fun add(item : Nota) {
        data.add(item)
        notifyDataSetChanged()
    }

    fun add(itens: List<Nota>) {
        data.clear()
        data.addAll(itens)
        notifyDataSetChanged()
    }

    fun remove(item: Nota) {
        data.remove(item)
        notifyDataSetChanged()
    }

    inner class NotasViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: Nota) {
            with(view) {
                tvNota.text = item.texto
            }
        }
    }
}
package com.example.arin_canvas.home.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arin_canvas.databinding.ItemPendudukBinding

class WargaAdapter(private val list: List<WargaModel>) : RecyclerView.Adapter<WargaAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPendudukBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPendudukBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvNamaPenduduk.text = item.nama
        holder.binding.tvStatusPenduduk.text = item.nik

        // Memuat foto dengan Glide
        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.binding.imgPenduduk)
    }

    override fun getItemCount() = list.size
}
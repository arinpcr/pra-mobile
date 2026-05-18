package com.example.arin_canvas.home.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arin_canvas.databinding.ItemFasilitasBinding

class FasilitasAdapter(
    private val fasilitasList: List<FasilitasModel>,
    private val onItemClick: (FasilitasModel) -> Unit
) : RecyclerView.Adapter<FasilitasAdapter.FasilitasViewHolder>() {

    inner class FasilitasViewHolder(val binding: ItemFasilitasBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FasilitasViewHolder {
        val binding = ItemFasilitasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FasilitasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FasilitasViewHolder, position: Int) {
        val item = fasilitasList[position]
        with(holder.binding) {
            tvNamaFasilitas.text = item.nama
            tvLokasiFasilitas.text = item.lokasi
            Glide.with(holder.itemView.context).load(item.imageUrl).into(imgFasilitas)
            root.setOnClickListener { onItemClick(item) }
        }
    }

    override fun getItemCount(): Int = fasilitasList.size
}
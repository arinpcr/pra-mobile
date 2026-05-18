package com.example.arin_canvas.home.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arin_canvas.databinding.ItemPendudukBinding

class PendudukAdapter(
    private val pendudukList: List<PendudukModel>,
    private val onItemClick: (PendudukModel) -> Unit
) : RecyclerView.Adapter<PendudukAdapter.PendudukViewHolder>() {

    inner class PendudukViewHolder(val binding: ItemPendudukBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendudukViewHolder {
        val binding = ItemPendudukBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PendudukViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PendudukViewHolder, position: Int) {
        val item = pendudukList[position]
        with(holder.binding) {
            tvNamaPenduduk.text = item.nama
            tvStatusPenduduk.text = item.status

            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgPenduduk)

            root.setOnClickListener { onItemClick(item) }
        }
    }

    override fun getItemCount(): Int = pendudukList.size
}
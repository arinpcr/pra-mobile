package com.example.arin_canvas.home.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arin_canvas.databinding.ItemPengumumanBinding

class PengumumanAdapter(
    private val pengumumanList: List<PengumumanModel>,
    private val onItemClick: (PengumumanModel) -> Unit
) : RecyclerView.Adapter<PengumumanAdapter.PengumumanViewHolder>() {

    inner class PengumumanViewHolder(val binding: ItemPengumumanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengumumanViewHolder {
        val binding = ItemPengumumanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PengumumanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PengumumanViewHolder, position: Int) {
        val item = pengumumanList[position]
        with(holder.binding) {
            tvJudul.text = item.judul
            tvTanggal.text = item.tanggal
            tvIsi.text = item.isiSingkat
            root.setOnClickListener { onItemClick(item) }
        }
    }

    override fun getItemCount(): Int = pengumumanList.size
}
package com.example.arin_canvas.home.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arin_canvas.databinding.ItemRowKependudukanBinding
import com.example.arin_canvas.home.pertemuan10.KeluargaModel

// 1. ADAPTER DATA KELUARGA
class KeluargaAdapter(private val list: List<KeluargaModel>) : RecyclerView.Adapter<KeluargaAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRowKependudukanBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemRowKependudukanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitleRow.text = item.kepalaKeluarga
        holder.binding.tvSubtitleRow.text = "No. KK: ${item.noKK}"
        holder.binding.tvBadgeRow.text = "${item.jmlAnggota} Anggota"
    }
    override fun getItemCount() = list.size
}

// 2. ADAPTER ANGGOTA KELUARGA
class AnggotaAdapter(private val list: List<AnggotaKeluargaModel>) : RecyclerView.Adapter<AnggotaAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRowKependudukanBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemRowKependudukanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitleRow.text = item.namaAnggota
        holder.binding.tvSubtitleRow.text = "Hubungan: ${item.hubungan}"
        holder.binding.tvBadgeRow.text = "${item.umur} Tahun"
    }
    override fun getItemCount() = list.size
}

// 3. ADAPTER DATA KELAHIRAN
class KelahiranAdapter(private val list: List<KelahiranModel>) : RecyclerView.Adapter<KelahiranAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRowKependudukanBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemRowKependudukanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitleRow.text = item.namaBayi
        holder.binding.tvSubtitleRow.text = "Nama Ibu: ${item.namaIbu}"
        holder.binding.tvBadgeRow.text = item.tglLahir
    }
    override fun getItemCount() = list.size
}

// 4. ADAPTER DATA KEMATIAN
class KematianAdapter(private val list: List<KematianModel>) : RecyclerView.Adapter<KematianAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRowKependudukanBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemRowKependudukanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitleRow.text = item.namaMendiang
        holder.binding.tvSubtitleRow.text = "Penyebab: ${item.penyebab}"
        holder.binding.tvBadgeRow.text = item.tglWafat
    }
    override fun getItemCount() = list.size
}

// 5. ADAPTER DATA PINDAH
class PindahAdapter(private val list: List<PindahModel>) : RecyclerView.Adapter<PindahAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemRowKependudukanBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemRowKependudukanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitleRow.text = item.namaWarga
        holder.binding.tvSubtitleRow.text = "Tujuan: ${item.tujuan}"
        holder.binding.tvBadgeRow.text = item.tglPindah
    }
    override fun getItemCount() = list.size
}
package com.example.arin_canvas.home.pertemuan10

// 1. Model Tab Data Warga
data class WargaModel(val nama: String, val nik: String, val imageUrl: String)

// 2. Model Tab Data Keluarga
data class KeluargaModel(val kepalaKeluarga: String, val noKK: String, val jmlAnggota: String)

// 3. Model Tab Anggota Keluarga
data class AnggotaKeluargaModel(val namaAnggota: String, val hubungan: String, val umur: String)

// 4. Model Tab Data Kelahiran
data class KelahiranModel(val namaBayi: String, val namaIbu: String, val tglLahir: String)

// 5. Model Tab Data Kematian
data class KematianModel(val namaMendiang: String, val tglWafat: String, val penyebab: String)

// 6. Model Tab Data Pindah
data class PindahModel(val namaWarga: String, val tujuan: String, val tglPindah: String)
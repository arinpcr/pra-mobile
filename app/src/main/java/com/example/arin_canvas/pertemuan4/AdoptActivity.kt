package com.example.arin_canvas.pertemuan4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.arin_canvas.R
import com.example.arin_canvas.databinding.ActivityAdoptBinding

class AdoptActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdoptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdoptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✨ KODE SAKTI MENGUBAH WARNA STATUS BAR (BATERAI/JAM) JADI PINK
        window.statusBarColor = ContextCompat.getColor(this, R.color.login_bg)

        // 1. LOGIKA TOMBOL BACK DI TOOLBAR (VERSI AMPUH: FINISH)
        binding.toolbarAdopt.setNavigationOnClickListener {
            finish() // Menutup halaman saat ini, otomatis memunculkan Dashboard di belakangnya
        }

        // 2. Menangkap data yang dikirim dari Dashboard (Intent Extras)
        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsi = intent.getStringExtra("EXTRA_DESKRIPSI")

        // 3. Menampilkan Data ke Layar
        if (judul != null) {
            // Ubah teks di body
            binding.tvTitleAdopt.text = judul
            // Ubah judul di Toolbar
            binding.toolbarAdopt.title = judul
        } else {
            binding.toolbarAdopt.title = "Adopt Pet"
        }

        if (deskripsi != null) {
            // Memunculkan deskripsi sebagai pop-up (Toast)
            Toast.makeText(this, deskripsi, Toast.LENGTH_LONG).show()
        }
    }
}
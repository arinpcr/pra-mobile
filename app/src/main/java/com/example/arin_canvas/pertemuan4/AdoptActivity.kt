package com.example.arin_canvas.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityAdoptBinding

class AdoptActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdoptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Memakai ViewBinding agar mudah mengatur tampilan
        binding = ActivityAdoptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Menangkap data yang dikirim dari Dashboard
        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsi = intent.getStringExtra("EXTRA_DESKRIPSI")

        // 2. Menampilkan Data
        if (judul != null) {
            // Mengubah teks judul "Adopt Pet" di layar
            binding.tvTitleAdopt.text = judul
        }
        if (deskripsi != null) {
            // Memunculkan deskripsi sebagai pop-up (Toast)
            Toast.makeText(this, deskripsi, Toast.LENGTH_LONG).show()
        }

        // 3. LOGIKA TOMBOL KEMBALI KE DASHBOARD
        binding.btnBackAdopt.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}
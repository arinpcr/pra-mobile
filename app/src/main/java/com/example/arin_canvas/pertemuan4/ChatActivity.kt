package com.example.arin_canvas.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Menangkap data yang dikirim dari Dashboard
        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsi = intent.getStringExtra("EXTRA_DESKRIPSI")

        // 2. Menampilkan Data sebagai Pop-up (Toast)
        if (judul != null && deskripsi != null) {
            val pesan = "Halaman: $judul\n$deskripsi"
            Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
        }

        // 3. LOGIKA TOMBOL KEMBALI KE DASHBOARD
        binding.btnBackChat.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            // Menghindari tumpukan halaman yang sama
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}
package com.example.arin_canvas.pertemuan4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.arin_canvas.R
import com.example.arin_canvas.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✨ Ubah warna status bar jadi login_bg (sama seperti AdoptActivity)
        window.statusBarColor = ContextCompat.getColor(this, R.color.login_bg)

        // 1. LOGIKA TOMBOL BACK DI TOOLBAR (VERSI AMPUH: FINISH)
        binding.toolbarChat.setNavigationOnClickListener {
            finish()
        }

        // 2. Menangkap data yang dikirim dari Dashboard
        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsi = intent.getStringExtra("EXTRA_DESKRIPSI")

        // 3. Menampilkan Data ke Layar
        if (judul != null) {
            binding.toolbarChat.title = judul
        } else {
            binding.toolbarChat.title = "Chat"
        }

        if (deskripsi != null) {
            Toast.makeText(this, deskripsi, Toast.LENGTH_LONG).show()
        }
    }
}
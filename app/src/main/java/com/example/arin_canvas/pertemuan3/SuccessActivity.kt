package com.example.arin_canvas.pertemuan3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.AuthActivity
import com.example.arin_canvas.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            // KEMBALI KE HALAMAN LOGIN
            val intent = Intent(this, AuthActivity::class.java)
            // Menghapus histori halaman agar user tidak bisa tekan tombol 'back' kembali ke halaman success
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
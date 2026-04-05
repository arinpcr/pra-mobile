package com.example.arin_canvas.pertemuan3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Binding
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Logika tombol Lets Explore (Continue)
        binding.btnContinue.setOnClickListener {
            // finish() artinya menutup halaman sukses dan balik ke login
            finish()
        }
    }
}
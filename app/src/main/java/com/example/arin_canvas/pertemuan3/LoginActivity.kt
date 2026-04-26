package com.example.arin_canvas.pertemuan3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityLoginBinding
import com.example.arin_canvas.pertemuan4.DashboardActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Inisialisasi SharedPreferences
        val sharedPreferences = getSharedPreferences("SIPADU_PREFS", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val email = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                // 2. Simpan status login menjadi TRUE
                val editor = sharedPreferences.edit()
                editor.putBoolean("IS_LOGIN", true)
                editor.apply()

                // 3. Pindah langsung ke Dashboard
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish() // Tutup halaman login

                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email & Password harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
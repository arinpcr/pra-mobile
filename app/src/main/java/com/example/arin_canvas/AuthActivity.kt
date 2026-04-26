package com.example.arin_canvas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityAuthBinding // Pastikan namanya sesuai XML kamu
import com.example.arin_canvas.pertemuan4.DashboardActivity

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Logika Modul: Username harus sama dengan Password
            if (username == password && username.isNotEmpty()) {

                // Simpan ke SharedPreferences
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()

                // Pindah ke MainActivity (Dashboard)
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                // Tampilkan AlertDialog jika salah
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username dan Password harus sama! Silahkan coba lagi.")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}
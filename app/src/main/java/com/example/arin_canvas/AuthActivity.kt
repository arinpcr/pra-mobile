package com.example.arin_canvas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        // 1. TOMBOL LOGIN & VALIDASINYA
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Ambil data dari SharedPreferences (hasil registrasi)
            val savedUser = sharedPref.getString("reg_username", "")
            val savedPass = sharedPref.getString("reg_password", "")

            // Cek kondisi login (username == password ATAU sesuai data SharedPreferences)
            val isLoginLama = (username == password && username.isNotEmpty())
            val isLoginBaru = (username == savedUser && password == savedPass && username.isNotEmpty())

            if (isLoginLama || isLoginBaru) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()

                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username atau Password salah!")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        // 2. TOMBOL REGISTER TEKS (Memunculkan Dialog Email)
        binding.tvRegister.setOnClickListener {
            tampilkanDialogEmail()
        }
    }

    private fun tampilkanDialogEmail() {
        val inputEmail = EditText(this)
        inputEmail.hint = "Contoh: arin@gmail.com"

        // Memberi margin agar rapi
        val container = FrameLayout(this)
        val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(50, 20, 50, 0)
        inputEmail.layoutParams = params
        container.addView(inputEmail)

        MaterialAlertDialogBuilder(this)
            .setTitle("Register With Gmail")
            .setMessage("Masukkan email Google Anda:")
            .setView(container)
            .setPositiveButton("Lanjut") { _, _ ->
                val email = inputEmail.text.toString().trim()

                // Validasi Email
                if (email.isEmpty() || !email.endsWith("@gmail.com")) {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Format Tidak Valid")
                        .setMessage("Email tidak boleh kosong dan harus menggunakan domain @gmail.com")
                        .setPositiveButton("Mengerti", null)
                        .show()
                } else {
                    // Jika valid, arahkan ke halaman registrasi dan bawa emailnya
                    val intent = Intent(this, RegisterActivity::class.java)
                    intent.putExtra("EXTRA_EMAIL", email)
                    startActivity(intent)
                }
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}
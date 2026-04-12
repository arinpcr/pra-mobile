package com.example.arin_canvas.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // PINDAH KE HALAMAN SUCCESS
                val intent = Intent(this, SuccessActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email & Password harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
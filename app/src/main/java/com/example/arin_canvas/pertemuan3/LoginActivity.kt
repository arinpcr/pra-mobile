package com.example.arin_canvas.pertemuan3

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
                // JURUS SAKTI PINDAH HALAMAN
                val pindahKeSukses = android.content.Intent(this, SuccessActivity::class.java)
                startActivity(pindahKeSukses)

                // Pesan kecil (Optional)
                android.widget.Toast.makeText(this, "Login Berhasil !", android.widget.Toast.LENGTH_SHORT).show()
            } else {
                android.widget.Toast.makeText(this, "Isi email sama passwordnya dulu ya!", android.widget.Toast.LENGTH_SHORT).show()
            }
        }
    }
}
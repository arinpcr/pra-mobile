package com.example.arin_canvas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityRegisterBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.arin_canvas.home.pertemuan3.SuccessActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil email dari AuthActivity dan pasang ke EditText
        val emailBawaan = intent.getStringExtra("EXTRA_EMAIL")
        binding.etRegEmail.setText(emailBawaan)

        binding.btnSubmitRegister.setOnClickListener {
            val name = binding.etRegName.text.toString().trim()
            val email = binding.etRegEmail.text.toString().trim()
            val user = binding.etRegUsername.text.toString().trim()
            val pass = binding.etRegPassword.text.toString()

            // VALIDASI
            if (name.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                tampilkanError("Semua kolom harus diisi!")
            } else if (user.contains(" ")) {
                tampilkanError("Username tidak boleh menggunakan spasi!")
            } else if (pass.length < 6) {
                tampilkanError("Password minimal harus 6 karakter!")
            } else {
                // Jika lolos semua validasi, simpan ke SharedPreferences
                val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("reg_name", name)
                editor.putString("reg_email", email)
                editor.putString("reg_username", user)
                editor.putString("reg_password", pass)
                editor.apply()

                // Pindah ke halaman Sukses
                startActivity(Intent(this, SuccessActivity::class.java))
                finish()
            }
        }
    }

    private fun tampilkanError(pesan: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Registrasi Gagal")
            .setMessage(pesan)
            .setPositiveButton("Perbaiki", null)
            .show()
    }
}
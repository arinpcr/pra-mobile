package com.example.arin_canvas.pertemuan4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityDashboardBinding
import com.example.arin_canvas.pertemuan2.BangunRuangActivity
import com.example.arin_canvas.AuthActivity // Pastikan path ini benar
import com.example.arin_canvas.WebViewActivity // Import halaman WebView-mu
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Tombol Bangun Ruang
        binding.cardBangunRuang.setOnClickListener {
            pindahHalaman(BangunRuangActivity::class.java, "Bangun Ruang", "Rumus Volume & Luas")
        }

        // 2. Tombol Adopt
        binding.cardAdoptPet.setOnClickListener {
            pindahHalaman(AdoptActivity::class.java, "Adopt Pet", "Cari Sahabat Bulu")
        }

        // 3. Tombol Chat
        binding.cardPetChat.setOnClickListener {
            pindahHalaman(ChatActivity::class.java, "Pet Chat", "Ngobrol bareng Komunitas")
        }

        // ✨ 4. TOMBOL WEB BINA DESA (YANG TADI KETINGGALAN)
        binding.cardWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        // 5. Tombol Logout
        binding.btnLogout.setOnClickListener {
            tampilkanDialogLogout()
        }
    }

    // Fungsi pembantu untuk pindah halaman dengan data (Intent)
    private fun <T> pindahHalaman(target: Class<T>, judul: String, deskripsi: String) {
        val intent = Intent(this, target)
        intent.putExtra("EXTRA_JUDUL", judul)
        intent.putExtra("EXTRA_DESKRIPSI", deskripsi)
        startActivity(intent)
    }

    private fun tampilkanDialogLogout() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi Logout")
        builder.setMessage("Yakin mau keluar?")
        builder.setPositiveButton("Ya") { dialog, _ ->

            // ✨ Hapus session login di SharedPreferences
            val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()

            // Kembali ke AuthActivity
            startActivity(Intent(this, AuthActivity::class.java))
            finishAffinity()
            dialog.dismiss()
        }
        builder.setNegativeButton("Tidak") { _, _ ->
            Snackbar.make(binding.root, "Logout dibatalkan", 2000).show()
        }
        builder.show()
    }
}
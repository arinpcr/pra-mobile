package com.example.arin_canvas.pertemuan4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.databinding.ActivityDashboardBinding
import com.example.arin_canvas.pertemuan2.BangunRuangActivity
import com.example.arin_canvas.pertemuan3.LoginActivity
import com.google.android.material.snackbar.Snackbar


class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol 1: Bangun Ruang
        binding.cardBangunRuang.setOnClickListener {
            pindahHalaman(BangunRuangActivity::class.java, "Bangun Ruang", "Rumus Volume & Luas")
        }

        // Tombol 2: Adopt
        binding.cardAdoptPet.setOnClickListener {
            pindahHalaman(AdoptActivity::class.java, "Adopt Pet", "Cari Sahabat Bulu")
        }

        // Tombol 3: Chat
        binding.cardPetChat.setOnClickListener {
            pindahHalaman(ChatActivity::class.java, "Pet Chat", "Ngobrol bareng Komunitas")
        }

        // Tombol 4: Logout (Alert Dialog)
        binding.btnLogout.setOnClickListener {
            tampilkanDialogLogout()
        }
    }

    private fun <T> pindahHalaman(target: Class<T>, judul: String, deskripsi: String) {
        val intent = Intent(this, target)
        intent.putExtra("EXTRA_JUDUL", judul)
        intent.putExtra("EXTRA_DESKRIPSI", deskripsi)
        startActivity(intent)
    }

    private fun tampilkanDialogLogout() {
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi Logout")
        builder.setMessage("Yakin mau keluar?")
        builder.setPositiveButton("Ya") { _, _ ->
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity() // Tutup semua halaman biar beneran logout
        }
        builder.setNegativeButton("Tidak") { _, _ ->
            com.google.android.material.snackbar.Snackbar.make(binding.root, "Logout dibatalkan", 2000).show()
        }
        builder.show()
    }
}
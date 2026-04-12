package com.example.arin_canvas.pertemuan2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.R
import com.example.arin_canvas.pertemuan4.DashboardActivity
import kotlin.math.PI
import kotlin.math.pow

class BangunRuangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menangkap data dari Dashboard dan menampilkannya sebagai Toast
        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsi = intent.getStringExtra("EXTRA_DESKRIPSI")
        if (judul != null && deskripsi != null) {
            Toast.makeText(this, "Halaman: $judul\n$deskripsi", Toast.LENGTH_LONG).show()
        }

        // --- KODE RUMUS KAMU YANG SEBELUMNYA TETAP AMAN DI SINI ---
        val etJariJari = findViewById<EditText>(R.id.etJariJari)
        val etTinggi = findViewById<EditText>(R.id.etTinggi)
        val btnLingkaran = findViewById<Button>(R.id.btnLingkaran)
        val btnTabung = findViewById<Button>(R.id.btnTabung)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // INISIALISASI TOMBOL KEMBALI
        val btnBack = findViewById<Button>(R.id.btn_back_to_dashboard)

        btnLingkaran.setOnClickListener {
            val rString = etJariJari.text.toString()
            if (rString.isNotEmpty()) {
                val r = rString.toDouble()
                val luas = PI * r.pow(2)
                tvHasil.text = "Luas Lingkaran: %.2f".format(luas)
                Log.d("ArinCanvasLog", "Berhasil hitung lingkaran! Jari-jari: $r, Hasil: $luas")
            } else {
                Toast.makeText(this, "Jari-jarinya diisi dulu ya!", Toast.LENGTH_SHORT).show()
            }
        }

        btnTabung.setOnClickListener {
            val rString = etJariJari.text.toString()
            val tString = etTinggi.text.toString()
            if (rString.isNotEmpty() && tString.isNotEmpty()) {
                val r = rString.toDouble()
                val t = tString.toDouble()
                val volume = PI * r.pow(2) * t
                tvHasil.text = "Volume Tabung: %.2f".format(volume)
                Log.d("ArinCanvasLog", "Berhasil hitung tabung! r: $r, t: $t, Hasil: $volume")
            } else {
                Toast.makeText(this, "Jari-jari dan Tingginya harus diisi dua-duanya!", Toast.LENGTH_SHORT).show()
            }
        }

        // LOGIKA TOMBOL KEMBALI KE DASHBOARD
        btnBack.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}
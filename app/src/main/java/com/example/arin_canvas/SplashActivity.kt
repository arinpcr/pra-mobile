package com.example.arin_canvas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

// Import manual karena beda folder
import com.example.arin_canvas.AuthActivity // ⬅️ Ganti jadi AuthActivity
import com.example.arin_canvas.pertemuan4.DashboardActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Sembunyikan Action Bar (Judul Aplikasi di atas) biar Splash Screen full layar
        supportActionBar?.hide()

        // Delay 2 detik (2000ms) sesuai instruksi di modul
        Handler(Looper.getMainLooper()).postDelayed({

            // ✨ CEK SHaredPreferences
            val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {
                // Jika sudah login (true), langsung lompat ke Dashboard
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                // Jika belum login (false), arahkan ke halaman AuthActivity
                startActivity(Intent(this, AuthActivity::class.java))
            }
            finish() // Tutup halaman Splash agar tidak bisa di-back
        }, 2000)
    }
}
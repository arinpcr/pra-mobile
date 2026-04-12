package com.example.arin_canvas.pertemuan4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.arin_canvas.R

class MapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cukup panggil layout XML-nya saja, hapus kode EdgeToEdge yang bikin error

        setContentView(R.layout.activity_maps)
    }
}
package com.example.arin_canvas.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.arin_canvas.BaseActivity
import com.example.arin_canvas.R

class MoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout untuk fragment ini
        val view = inflater.inflate(R.layout.fragment_more, container, false)

        // 1. Setup Toolbar agar tombol Back berfungsi
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_more)
        toolbar.setNavigationOnClickListener {
            // Kembali ke tab Home di Bottom Navigation
            (activity as? BaseActivity)?.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_nav_view)?.selectedItemId = R.id.nav_home
        }

        // 2. Setup ListView Sederhana (Sesuai Permintaan Dosen)
        val listView = view.findViewById<ListView>(R.id.listViewSettings)

        // Data array untuk menu pengaturan
        val menuList = arrayOf(
            "⚙️ Pengaturan Akun",
            "🔒 Privasi & Keamanan",
            "🔔 Notifikasi",
            "🌐 Bahasa (Language)",
            "❓ Bantuan & Dukungan",
            "📄 Syarat & Ketentuan",
            "💡 Beri Rating Aplikasi"
        )

        // Menggunakan ArrayAdapter bawaan Android (simple_list_item_1)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            menuList
        )

        listView.adapter = adapter

        // Memberikan aksi ketika item ListView diklik
        listView.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            Toast.makeText(requireContext(), "Membuka: $selectedItem", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
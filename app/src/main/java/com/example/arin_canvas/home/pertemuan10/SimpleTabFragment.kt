package com.example.arin_canvas.pertemuan10

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SimpleTabFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Membuat tampilan teks secara otomatis tanpa perlu file XML
        return TextView(requireContext()).apply {
            text = arguments?.getString("title") ?: "Halaman Kosong"
            textSize = 20f
            setTextColor(Color.parseColor("#F24174")) // Warna pink
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#FDF2F5"))
        }
    }

    companion object {
        fun newInstance(title: String) = SimpleTabFragment().apply {
            arguments = Bundle().apply { putString("title", title) }
        }
    }
}
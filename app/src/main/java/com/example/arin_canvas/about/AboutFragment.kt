package com.example.arin_canvas.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.arin_canvas.R
import com.example.arin_canvas.BaseActivity

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        // Setup Tombol Back di Toolbar
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_about)
        toolbar.setNavigationOnClickListener {
            // Memanggil BaseActivity untuk memindahkan navigasi bawah ke Home
            (activity as? BaseActivity)?.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_nav_view)?.selectedItemId = R.id.nav_home
        }

        return view
    }
}
package com.example.arin_canvas.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.arin_canvas.R
import com.example.arin_canvas.BaseActivity

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Setup Toolbar Back Button
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_profile)
        toolbar.setNavigationOnClickListener {
            // Kembali ke tab Home di Bottom Navigation
            (activity as? BaseActivity)?.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_nav_view)?.selectedItemId = R.id.nav_home
        }

        return view
    }
}
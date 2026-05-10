package com.example.arin_canvas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.arin_canvas.databinding.ActivityBaseBinding
import com.example.arin_canvas.home.HomeFragment
import com.example.arin_canvas.message.MessageFragment
import com.example.arin_canvas.more.MoreFragment // <-- IMPORT FRAGMENT BARU
import com.example.arin_canvas.about.AboutFragment
import com.example.arin_canvas.profile.ProfileFragment

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_message -> {
                    replaceFragment(MessageFragment())
                    true
                }
                R.id.nav_more -> { // <-- LOGIKA UNTUK MENU LAINNYA
                    replaceFragment(MoreFragment())
                    true
                }
                R.id.nav_about -> {
                    replaceFragment(AboutFragment())
                    true
                }
                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
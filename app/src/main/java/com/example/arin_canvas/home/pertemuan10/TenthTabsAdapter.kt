package com.example.arin_canvas.pertemuan10

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.arin_canvas.home.pertemuan10.TabCFragment

class TenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCFragment() // Data Warga
            1 -> TabAFragment() // Data Keluarga
            2 -> TabBFragment() // Anggota Keluarga
            3 -> TabDFragment() // Data Kelahiran
            4 -> TabEFragment() // Data Kematian
            5 -> TabFFragment() // Data Pindah
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}
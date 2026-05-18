package com.example.arin_canvas.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arin_canvas.databinding.FragmentTabDBinding
import com.example.arin_canvas.home.pertemuan10.KelahiranAdapter
import com.example.arin_canvas.home.pertemuan10.KelahiranModel

class TabDFragment : Fragment() {
    private var _binding: FragmentTabDBinding? = null
    private val binding get() = _binding!!

    private val kelahiranList = listOf(
        KelahiranModel("Bayi Arka Perkasa", "Ibu Siti Aminah", "12 Mei 2026"),
        KelahiranModel("Bayi Nayla Putri", "Ibu Rina Melati", "02 April 2026")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTabDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvKelahiran.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKelahiran.adapter = KelahiranAdapter(kelahiranList)
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
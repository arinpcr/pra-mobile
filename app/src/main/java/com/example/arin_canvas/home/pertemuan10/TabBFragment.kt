package com.example.arin_canvas.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arin_canvas.databinding.FragmentTabBBinding
import com.example.arin_canvas.home.pertemuan10.AnggotaAdapter
import com.example.arin_canvas.home.pertemuan10.AnggotaKeluargaModel

class TabBFragment : Fragment() {
    private var _binding: FragmentTabBBinding? = null
    private val binding get() = _binding!!

    private val anggotaList = listOf(
        AnggotaKeluargaModel("Siti Aminah", "Istri", "38"),
        AnggotaKeluargaModel("Andi Pratama", "Anak Kandung", "14"),
        AnggotaKeluargaModel("Rina Melati", "Anak Kandung", "9")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTabBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPengumuman.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPengumuman.adapter = AnggotaAdapter(anggotaList)
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
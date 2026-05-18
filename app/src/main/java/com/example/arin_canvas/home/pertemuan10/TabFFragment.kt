package com.example.arin_canvas.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arin_canvas.databinding.FragmentTabFBinding
import com.example.arin_canvas.home.pertemuan10.PindahAdapter
import com.example.arin_canvas.home.pertemuan10.PindahModel

class TabFFragment : Fragment() {
    private var _binding: FragmentTabFBinding? = null
    private val binding get() = _binding!!

    private val pindahList = listOf(
        PindahModel("Danang Wijaya", "Pindah ke Kota Pekanbaru", "14 Mei 2026"),
        PindahModel("Megawati", "Pindah ke Kabupaten Kampar", "01 Mei 2026")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTabFBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPindah.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPindah.adapter = PindahAdapter(pindahList)
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
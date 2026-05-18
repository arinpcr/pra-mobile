package com.example.arin_canvas.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arin_canvas.databinding.FragmentTabABinding
import com.example.arin_canvas.home.pertemuan10.KeluargaAdapter
import com.example.arin_canvas.home.pertemuan10.KeluargaModel

class TabAFragment : Fragment() {
    private var _binding: FragmentTabABinding? = null
    private val binding get() = _binding!!

    private val keluargaList = listOf(
        KeluargaModel("Keluarga Budi Santoso", "1471012345670001", "4"),
        KeluargaModel("Keluarga Ahmad Dahlan", "1471039876540003", "5"),
        KeluargaModel("Keluarga Joko Susilo", "1471021122330045", "3")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTabABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFasilitas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFasilitas.adapter = KeluargaAdapter(keluargaList)
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
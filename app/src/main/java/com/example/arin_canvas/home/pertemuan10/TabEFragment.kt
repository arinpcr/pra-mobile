package com.example.arin_canvas.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arin_canvas.databinding.FragmentTabEBinding
import com.example.arin_canvas.home.pertemuan10.KematianAdapter
import com.example.arin_canvas.home.pertemuan10.KematianModel

class TabEFragment : Fragment() {
    private var _binding: FragmentTabEBinding? = null
    private val binding get() = _binding!!

    private val kematianList = listOf(
        KematianModel("Suryadi (Mbah Sur)", "10 Mei 2026", "Sakit Usia Lanjut"),
        KematianModel("Supriatna", "28 Maret 2026", "Serangan Jantung")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTabEBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvKematian.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKematian.adapter = KematianAdapter(kematianList)
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
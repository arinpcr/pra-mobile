package com.example.arin_canvas.home.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.arin_canvas.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {
    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    // KUMPULAN DATA WARGA YANG DIPERBANYAK AGAR BISA DI-SCROLL
    private val wargaList = listOf(
        WargaModel("Budi Santoso", "NIK: 147101xxxxxx0001", "https://i.pravatar.cc/150?img=11"),
        WargaModel("Siti Aminah", "NIK: 147102xxxxxx0002", "https://i.pravatar.cc/150?img=5"),
        WargaModel("Ahmad Dahlan", "NIK: 147103xxxxxx0003", "https://i.pravatar.cc/150?img=8"),
        WargaModel("Rina Melati", "NIK: 147101xxxxxx0004", "https://i.pravatar.cc/150?img=9"),
        WargaModel("Joko Widodo", "NIK: 147105xxxxxx0005", "https://i.pravatar.cc/150?img=15"),
        WargaModel("Dewi Lestari", "NIK: 147106xxxxxx0006", "https://i.pravatar.cc/150?img=20"),
        WargaModel("Andi Pratama", "NIK: 147107xxxxxx0007", "https://i.pravatar.cc/150?img=33"),
        WargaModel("Maya Sari", "NIK: 147108xxxxxx0008", "https://i.pravatar.cc/150?img=42"),
        WargaModel("Farhan Maulana", "NIK: 147109xxxxxx0009", "https://i.pravatar.cc/150?img=12"),
        WargaModel("Nisa Sabyan", "NIK: 147110xxxxxx0010", "https://i.pravatar.cc/150?img=16"),
        WargaModel("Reza Rahadian", "NIK: 147111xxxxxx0011", "https://i.pravatar.cc/150?img=13"),
        WargaModel("Putri Marino", "NIK: 147112xxxxxx0012", "https://i.pravatar.cc/150?img=22"),
        WargaModel("Fiersa Besari", "NIK: 147113xxxxxx0013", "https://i.pravatar.cc/150?img=51"),
        WargaModel("Isyana Sarasvati", "NIK: 147114xxxxxx0014", "https://i.pravatar.cc/150?img=47")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menampilkan data dalam bentuk Grid (2 Kolom)
        binding.rvPenduduk.layoutManager = GridLayoutManager(requireContext(), 2)

        // Memanggil WargaAdapter untuk menggabungkan data dengan item_penduduk.xml
        binding.rvPenduduk.adapter = WargaAdapter(wargaList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
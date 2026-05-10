package com.example.arin_canvas.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.arin_canvas.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    // Membuat data dinamis sesuai Custom Adapter
    private val messageList = listOf(
        MessageModel("Bpk. RT 03 (Pak Budi)", "Jangan lupa gotong royong di simpang tiga besok pagi ya...", "https://avatar.iran.liara.run/public/11", "15 min", 1, true),
        MessageModel("Admin Desa SIPADU", "Surat pengantar KTP Anda sudah dicetak. Silakan diambil di balai.", "https://avatar.iran.liara.run/public/girl", "32 min", 2, true),
        MessageModel("Pengumuman Desa", "Penyaluran dana bansos akan dilaksanakan pada hari Jumat...", "https://avatar.iran.liara.run/public/job/police", "1 hour", 0, false),
        MessageModel("Bu RT 03", "Ibu-ibu, arisan bulan ini di rumah Bu Sisca ya.", "https://avatar.iran.liara.run/public/55", "3 hours", 0, false),
        MessageModel("Pemuda Karang Taruna", "Rapat persiapan 17an malam ini jam 20.00 WIB.", "https://avatar.iran.liara.run/public/boy", "Yesterday", 5, true)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menghubungkan MessageAdapter ke ListView
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
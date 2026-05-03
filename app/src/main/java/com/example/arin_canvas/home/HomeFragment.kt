package com.example.arin_canvas.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.arin_canvas.AuthActivity
import com.example.arin_canvas.WebViewActivity
import com.example.arin_canvas.databinding.FragmentHomeBinding
import com.example.arin_canvas.pertemuan2.BangunRuangActivity
import com.example.arin_canvas.pertemuan4.AdoptActivity
import com.example.arin_canvas.pertemuan4.ChatActivity
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        // 1. Tombol Bangun Ruang
        binding.cardBangunRuang.setOnClickListener {
            pindahHalaman(BangunRuangActivity::class.java, "Bangun Ruang", "Rumus Volume & Luas")
        }

        // 2. Tombol Adopt Pet
        binding.cardAdoptPet.setOnClickListener {
            pindahHalaman(AdoptActivity::class.java, "Adopt Pet", "Cari Sahabat Bulu")
        }

        // 3. Tombol Chat
        binding.cardPetChat.setOnClickListener {
            pindahHalaman(ChatActivity::class.java, "Pet Chat", "Ngobrol bareng Komunitas")
        }

        // 4. Tombol Web Bina Desa
        binding.cardWebView.setOnClickListener {
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            startActivity(intent)
        }

        // 5. Tombol Logout
        binding.btnLogout.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Konfirmasi Logout")
            builder.setMessage("Yakin mau keluar?")
            builder.setPositiveButton("Ya") { dialog, _ ->
                // Hapus session login
                val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                sharedPref.edit().clear().apply()

                // Kembali ke AuthActivity dan bersihkan task
                val intent = Intent(requireContext(), AuthActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
                dialog.dismiss()
            }
            builder.setNegativeButton("Tidak") { _, _ ->
                Snackbar.make(binding.root, "Logout dibatalkan", 2000).show()
            }
            builder.show()
        }
    }

    // Fungsi pembantu pindah halaman (Context disesuaikan untuk Fragment)
    private fun <T> pindahHalaman(target: Class<T>, judul: String, deskripsi: String) {
        val intent = Intent(requireContext(), target)
        intent.putExtra("EXTRA_JUDUL", judul)
        intent.putExtra("EXTRA_DESKRIPSI", deskripsi)
        startActivity(intent)
    }

    private fun tampilkanDialogLogout() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Konfirmasi Logout")
        builder.setMessage("Yakin mau keluar?")
        builder.setPositiveButton("Ya") { dialog, _ ->
            // Hapus session login
            val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            sharedPref.edit().clear().apply()

            // Kembali ke AuthActivity dan bersihkan task
            val intent = Intent(requireContext(), AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
            dialog.dismiss()
        }
        builder.setNegativeButton("Tidak") { _, _ ->
            Snackbar.make(binding.root, "Logout dibatalkan", 2000).show()
        }
        builder.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
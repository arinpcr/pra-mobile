package com.example.arin_canvas // Pastikan nama package sesuai dengan project kamu!

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.arin_canvas.databinding.ActivityModifiedBinding // Pastikan import binding sesuai package
import com.google.android.material.chip.Chip

class ModifiedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModifiedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup ViewBinding
        binding = ActivityModifiedBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Edge To Edge Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Mengaktifkan Toolbar Custom
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Dashboard SIPADU"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // 2. Logic Material Button & TextInputLayout
        binding.btnCari.setOnClickListener {
            val keyword = binding.etSearch.text.toString()
            if (keyword.isNotEmpty()) {
                Toast.makeText(this, "Mencari data: $keyword", Toast.LENGTH_SHORT).show()
            } else {
                binding.textInputLayout.error = "Data tidak boleh kosong!"
            }
        }

        // 3. Logic ChipGroup
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(this, "Menampilkan: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        // 4. Memanggil fungsi setup ListView
        setupListView()
    }

    private fun setupListView() {
        // Menggunakan menu-menu dropdown dari website SIPADU
        val menuSipadu = arrayOf(
            "👶 Data Kelahiran",
            "🪦 Data Kematian",
            "🚚 Data Pindah",
            "⚙️ Data User",
            "📞 Kontak Admin"
        )

        // Menerapkan ArrayAdapter dengan modifikasi tampilan
        val adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuSipadu) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val viewItem = super.getView(position, convertView, parent)
                val textView = viewItem.findViewById<TextView>(android.R.id.text1)

                // --- BAGIAN INI SUDAH DISESUAIKAN DENGAN TEMA PROFIL KAMU ---
                // Menggunakan warna teks login_bg agar senada dengan UI utama
                textView.setTextColor(ContextCompat.getColor(context, R.color.login_bg))
                textView.textSize = 16f
                textView.textAlignment = View.TEXT_ALIGNMENT_CENTER

                // Menerapkan Background Drawable SIPADU yang sudah disesuaikan warnanya
                viewItem.background = ContextCompat.getDrawable(context, R.drawable.bg_sipadu_list)
                // -------------------------------------------------------------

                return viewItem
            }
        }

        binding.listViewData.adapter = adapter

        // Aksi ketika item ListView diklik
        binding.listViewData.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Membuka ${menuSipadu[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    // Fungsi untuk tombol kembali (Back Arrow) di Toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
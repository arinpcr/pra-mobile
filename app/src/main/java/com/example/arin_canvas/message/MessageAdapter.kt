package com.example.arin_canvas.message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.arin_canvas.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding
        val view: View

        if (convertView == null) {
            binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = convertView.tag as ItemMessageBinding
            view = convertView
        }

        val data = messages[position]

        // Load gambar menggunakan Glide
        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.textTime.text = data.time

        // Logika menyembunyikan titik hijau jika offline
        binding.onlineIndicator.visibility = if (data.isOnline) View.VISIBLE else View.GONE

        // Logika menyembunyikan badge angka jika 0
        if (data.badgeCount > 0) {
            binding.badgeContainer.visibility = View.VISIBLE
            binding.textBadge.text = data.badgeCount.toString()
        } else {
            binding.badgeContainer.visibility = View.GONE
        }

        // Aksi klik per item menggunakan Snackbar sesuai modul
        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
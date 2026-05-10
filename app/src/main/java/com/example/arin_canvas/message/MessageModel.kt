package com.example.arin_canvas.message

data class MessageModel(
    val senderName: String,
    val messageText: String,
    val avatarUrl: String,
    val time: String,
    val badgeCount: Int,
    val isOnline: Boolean
)
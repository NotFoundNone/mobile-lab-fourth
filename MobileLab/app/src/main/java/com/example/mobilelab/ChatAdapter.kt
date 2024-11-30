package com.example.mobilelab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chatList: List<Chat>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    // ViewHolder представляет каждый элемент списка
    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.chat_name)
        val timeTextView: TextView = itemView.findViewById(R.id.chat_time)
        val messageTextView: TextView = itemView.findViewById(R.id.chat_message)
    }

    // Создание нового элемента ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    // Привязка данных к элементам ViewHolder
    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chatList[position]
        holder.nameTextView.text = chat.name
        holder.timeTextView.text = chat.time
        holder.messageTextView.text = chat.message
    }

    // Возвращает количество элементов в списке
    override fun getItemCount(): Int {
        return chatList.size
    }
}

package com.example.mobilelab.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilelab.Chat
import com.example.mobilelab.ChatAdapter
import com.example.mobilelab.R

class ChatListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.chat_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = arguments?.getString("LOGIN")
        val loginTextView = view.findViewById<TextView>(R.id.loginTextView)
        loginTextView.text = login

        // Список фиктивных данных
        val chatList = listOf(
            Chat("Андрей", "12:30 PM", "Привет, как дела?"),
            Chat("Марина", "12:32 PM", "Занята на работе."),
            Chat("Сергей", "12:45 PM", "Поговорим позже."),
            Chat("Ольга", "1:00 PM", "Привет, давно не виделись!"),
            Chat("Виктор", "1:15 PM", "Когда встречаемся?")
        )

        // Найдите RecyclerView в макете
        val recyclerView = view.findViewById<RecyclerView>(R.id.chat_list)

        // Установите макет-менеджер
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Подключите адаптер
        recyclerView.adapter = ChatAdapter(chatList)
    }

    companion object {
        fun newInstance(login: String): ChatListFragment {
            val args = Bundle()
            args.putString("LOGIN", login)
            val fragment = ChatListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
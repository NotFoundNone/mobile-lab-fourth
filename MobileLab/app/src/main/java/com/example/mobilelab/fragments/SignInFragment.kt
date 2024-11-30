package com.example.mobilelab.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.mobilelab.R

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_in_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.signIn)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val login = arguments?.getString("LOGIN")
        val password = arguments?.getString("PASSWORD")

        val signinButton: Button = view.findViewById(R.id.signInButton)
        signinButton.setOnClickListener {
            val login = view.findViewById<EditText>(R.id.email).text.toString()
            val password = view.findViewById<EditText>(R.id.password).text.toString()

            if ((login == "Dema" || login == "Nikita") && password == "123456") {
                Log.d("SignInFragment", "Auth success!")

                val chatListFragment = ChatListFragment.newInstance(login)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, chatListFragment)
                    .commit()
            } else {
                Log.d("SignInFragment", "Auth failed!")
                Toast.makeText(activity, "Неверные данные", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance(login: String, password: String): RegisterFragment {
            val args = Bundle()
            args.putString("LOGIN", login)
            args.putString("PASSWORD", password)
            val fragment = RegisterFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
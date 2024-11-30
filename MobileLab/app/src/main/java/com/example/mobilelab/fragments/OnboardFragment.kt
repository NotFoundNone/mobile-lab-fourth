package com.example.mobilelab.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobilelab.R
import androidx.fragment.app.Fragment

class OnboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.onboard_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nextButton = view.findViewById<Button>(R.id.next_button)

        nextButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegisterFragment())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("OnboardFragment", "OnboardFragment onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnboardFragment", "OnboardFragment onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("OnboardFragment", "OnboardFragment onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnboardFragment", "OnboardFragment onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnboardFragment", "OnboardFragment onDestroy called")
    }
}

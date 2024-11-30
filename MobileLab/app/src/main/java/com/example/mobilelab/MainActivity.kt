package com.example.mobilelab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelab.fragments.OnboardFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Заменяем контейнер фрагментом OnboardFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnboardFragment())
                .commit()
        }
    }
}

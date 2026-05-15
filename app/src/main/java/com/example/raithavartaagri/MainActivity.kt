package com.example.raithavarta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.raithavarta.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView =
            findViewById(R.id.bottomNavigation)

        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        bottomNav.setOnItemSelectedListener { item ->

            val fragment = when (item.itemId) {

                R.id.nav_home -> HomeFragment()

                R.id.nav_weather -> WeatherFragment()

                R.id.nav_expert -> ExpertFragment()

                R.id.nav_success -> SuccessFragment()

                else -> HomeFragment()
            }

            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
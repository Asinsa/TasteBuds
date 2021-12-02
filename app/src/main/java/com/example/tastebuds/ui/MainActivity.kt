package com.example.tastebuds.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantreviewapp.Restaurant
import com.example.tastebuds.R
import com.example.tastebuds.databinding.ActivityMainBinding
import com.example.tastebuds.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigation

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)


        /*
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_review -> {
                    true
                }
                R.id.navigation_review -> {
                    true
                }
                else -> false
            }
        }

         */
    }

    fun getMain(): MainActivity {
        return this
    }

}
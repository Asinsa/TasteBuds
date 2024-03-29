package com.example.tastebuds.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tastebuds.R
import com.example.tastebuds.databinding.ActivityMainBinding
import com.example.tastebuds.databinding.FragmentHomeBinding
import com.example.tastebuds.ui.account.AccountFragment
import com.example.tastebuds.ui.account.AccountViewModel
import com.example.tastebuds.ui.account.LoginFragment
import com.example.tastebuds.ui.favourites.FavouritesFragment
import com.example.tastebuds.ui.home.HomeFragment
import com.example.tastebuds.ui.review.ReviewFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigation

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)
        
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        /*
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            System.out.println(item.itemId.toString() + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + R.id.navigation_login.toString())
            if (item.itemId == R.id.navigation_login){  //navigate to Fragment1 or Fragment2
                System.out.println(viewModel.getEmail() + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
                if (viewModel.loggedIn()) {
                    val newFragment: Fragment = AccountFragment()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.navigation_login, newFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                } else {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.nav_host_fragment_activity_main, LoginFragment()).commit()
                    }
                }

            }
            //Trigger the original listener for the other items
            NavigationUI.onNavDestinationSelected(item, navController)
            true

        }

         */



        /*
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    setCurrentFragment(HomeFragment())
                    true
                }
                R.id.navigation_review -> {
                    setCurrentFragment(ReviewFragment())
                    true
                }
                R.id.navigation_favourites -> {
                    setCurrentFragment(FavouritesFragment())
                    true
                }
                R.id.navigation_login -> {
                    //if (loggedIn()) {
                    //    setCurrentFragment(AccountFragment())
                   // } else {
                        setCurrentFragment(LoginFragment())
                   // }
                    true
                }
                R.id.action_navigation_login_to_navigation_account -> {
                    setCurrentFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }

         */
    }

    /*
    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_activity_main,fragment)
            commit()
        }

     */

    fun getMain(): MainActivity {
        return this
    }


}

package com.jesil.evaccinearchive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.jesil.evaccinearchive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initNavHost()
    }

    private fun initNavHost() {
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showHideToolbar(true)
                else -> showHideToolbar(false)
            }
        }
    }

    private fun showHideToolbar(state: Boolean) = with(binding.materialToolbar) {
        visibility = when (state) {
            true -> {
                View.VISIBLE
            }

            false -> {
                View.GONE
            }
        }
    }
}
package com.draccotech.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.draccotech.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LifeCycle","onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = binding.toolbar

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        savedInstanceState?.getString("editTextValue")?.let {
            binding.editTextText.setText(it)
        }

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(R.id.playerFragment, R.id.resultFragment), drawer)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.homeFragment -> bottomNav.visibility = View.GONE
                    else -> bottomNav.visibility = View.VISIBLE
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navDrawer.setupWithNavController(navController)
        bottomNav.setupWithNavController(navController)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("editTextValue", binding.editTextText.text.toString())
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle","onDestroy")
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}
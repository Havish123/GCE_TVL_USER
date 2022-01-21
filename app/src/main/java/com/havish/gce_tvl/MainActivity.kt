package com.havish.gce_tvl

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavView:BottomNavigationView
    private lateinit var navController:NavController

    private lateinit var drawerLayout:DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout=findViewById(R.id.drawerLayout)
        navView=findViewById(R.id.navigation_view)
        toggle=ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener(this)

        bottomNavView=findViewById(R.id.bottomNavigationView)
        navController=Navigation.findNavController(this@MainActivity,R.id.frame_layout)
        NavigationUI.setupWithNavController(bottomNavView,navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_developer->{
                Toast.makeText(this,"Developer",Toast.LENGTH_LONG).show()
            }
            R.id.navigation_video->{
                Toast.makeText(this,"Video",Toast.LENGTH_LONG).show()
            }
            R.id.navigation_ebook->{
                Toast.makeText(this,"Ebook",Toast.LENGTH_LONG).show()
            }
            R.id.navigation_rate->{
                Toast.makeText(this,"Rate",Toast.LENGTH_LONG).show()
            }
            R.id.navigation_themes->{
                Toast.makeText(this,"Themes",Toast.LENGTH_LONG).show()
            }
            R.id.navigation_website->{
                Toast.makeText(this,"Website",Toast.LENGTH_LONG).show()
            }
        }

        return true
    }
}
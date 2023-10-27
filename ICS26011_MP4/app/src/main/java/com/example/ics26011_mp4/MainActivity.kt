package com.example.ics26011_mp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerlayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val context: Context = MainActivity.applicationContext()

        drawerlayout = findViewById(R.id.drawer_layout)
        var navView : NavigationView = findViewById(R.id.nav_view)
        var toolbar : Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        navView.bringToFront()
        var toggle : ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MainMenuFragment()).commit()
            navView.setCheckedItem(R.id.nav_mainMenu)
        }
    }

    override fun onBackPressed() {
        if(drawerlayout.isDrawerOpen(GravityCompat.START)) {
            drawerlayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_mainMenu -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MainMenuFragment()).commit()
            R.id.nav_login -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LoginFragment()).commit()
            R.id.nav_register -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, RegisterFragment()).commit()
        }
        drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }
}





package com.example.bookhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout : DrawerLayout
    lateinit var coordiantorLayout : CoordinatorLayout
    lateinit var frameLayot : FrameLayout
    lateinit var navigationView : NavigationView
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coordiantorLayout = findViewById(R.id.coordinatlayout)
        drawerLayout = findViewById(R.id.drawerlayout)
        frameLayot = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationview)
        toolbar = findViewById(R.id.toolbar)
    SetUpToolbar()
       val actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu1->{
                    Toast.makeText(this@MainActivity, "dashboard", Toast.LENGTH_SHORT).show()
                }
                R.id.menu2->{
                    Toast.makeText(this@MainActivity, "Favourites", Toast.LENGTH_SHORT).show()
                }
                R.id.menu3->{
                    Toast.makeText(this@MainActivity, "Profile", Toast.LENGTH_SHORT).show()
                }
                R.id.menu4->{
                    Toast.makeText(this@MainActivity, "aboutme", Toast.LENGTH_SHORT).show()
                }
            }
            return@setNavigationItemSelectedListener true
            
        }

    }
    fun SetUpToolbar() {
 setSupportActionBar(toolbar)
    supportActionBar?.title = "Menu"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}
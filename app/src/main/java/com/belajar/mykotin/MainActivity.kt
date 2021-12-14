package com.belajar.mykotin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val clickme = findViewById<Button>(R.id.click_me)
//        clickme.setOnClickListener {
//            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        val actDua = findViewById<Button>(R.id.act_dua)
//        actDua.setOnClickListener {
//            val Intent = Intent(this, MainActivityDua::class.java)
//            startActivity(Intent)
//        }
//        val actTiga = findViewById<Button>(R.id.act_tiga)
//        actTiga.setOnClickListener {
//            val Intent = Intent(this, MainActivityTiga::class.java)
//            startActivity(Intent)
//        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(applicationContext, "Menu Home", Toast.LENGTH_SHORT)
                    .show()
                R.id.nav_message -> Toast.makeText(
                    applicationContext,
                    "Menu Message",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_sync -> Toast.makeText(applicationContext, "Menu Sync", Toast.LENGTH_SHORT)
                    .show()
                R.id.nav_trash -> Toast.makeText(
                    applicationContext,
                    "Menu Trash",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_setting -> Toast.makeText(
                    applicationContext,
                    "Menu  Setting",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_login -> Toast.makeText(
                    applicationContext,
                    "Menu Login",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_share -> Toast.makeText(
                    applicationContext,
                    "Menu Share",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_rate -> Toast.makeText(applicationContext, "Menu Rate", Toast.LENGTH_SHORT)
                    .show()

            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
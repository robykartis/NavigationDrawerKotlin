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
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var homeFragment: HomeFragment


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





        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        Default Home startup fragments
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        navView.setNavigationItemSelectedListener {


            it.isChecked = true

            when (it.itemId) {

                R.id.nav_home -> replaceFragment(HomeFragment(), it.title.toString())
                R.id.nav_message -> replaceFragment(MessageFragment(), it.title.toString())
                R.id.nav_sync -> Toast.makeText(applicationContext, "Menu Sync", Toast.LENGTH_SHORT)
                    .show()
                R.id.nav_trash -> Toast.makeText(
                    applicationContext,
                    "Menu Trash",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_setting -> replaceFragment(SettingFragment(), it.title.toString())
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


    //    Replace Frament Layouts
    private fun replaceFragment(fragment: Fragment, title: String) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, homeFragment).commit()
        }
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
package com.belajar.mykotin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivityDua : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dua)

        val actSatu = findViewById<Button>(R.id.act_satu)
        actSatu.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
        val actTiga = findViewById<Button>(R.id.act_tiga)
        actTiga.setOnClickListener {
            val Intent = Intent(this, MainActivityTiga::class.java)
            startActivity(Intent)
        }
    }
}
package com.belajar.mykotin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivityTiga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tiga)

        val actSatu = findViewById<Button>(R.id.act_satu)
        actSatu.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        val actdua = findViewById<Button>(R.id.act_dua)
        actdua.setOnClickListener {
            val Intent = Intent(this, MainActivityDua::class.java)
            startActivity(Intent)
        }


    }
}
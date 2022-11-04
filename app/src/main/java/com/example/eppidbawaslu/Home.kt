package com.example.eppidbawaslu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        
        
        val SOP : ImageButton = findViewById(R.id.SOP)
        SOP.setOnClickListener{
            val intent = Intent(this@Home, SOP::class.java)
            startActivity(intent)
        }



    }
}
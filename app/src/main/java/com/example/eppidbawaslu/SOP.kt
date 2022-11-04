package com.example.eppidbawaslu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class SOP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sop)

       val buttonSOP1 : Button = findViewById(R.id.buttonSOP1)

        buttonSOP1.setOnClickListener {

            val openURL=Intent(android.content.Intent.ACTION_VIEW)
            //openurl ke web
            openURL.data= Uri.parse("https://drive.google.com/file/d/1ZqAhCm_8_VyhN6e1Ffyov5XPvv-c9hsT/view")
        }
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        toolbar.setOnClickListener{
            val intent = Intent(this@SOP, Home::class.java)
            startActivity(intent)
        }
    }
}
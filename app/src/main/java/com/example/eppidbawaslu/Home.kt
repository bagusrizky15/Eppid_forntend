package com.example.eppidbawaslu

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.eppidbawaslu.databinding.ActivityMainBinding
import com.example.eppidbawaslu.databinding.ItemSlideBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots : ArrayList<TextView>


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(R.layout.activity_home)
            setContentView(binding.root)

            list.add(
                ImageData(
                    "D:\\EppidBawaslu2\\app\\src\\main\\res\\drawable"
                )
            )
            val SOP : ImageButton = findViewById(R.id.SOP)
            SOP.setOnClickListener{
                val intent = Intent(this@Home, SOP::class.java)
                startActivity(intent)
            }

            val Form : ImageButton = findViewById(R.id.formpermohonan)
            SOP.setOnClickListener{
                val intent = Intent(this@Home, Form_Permohonan_Informasi::class.java)
                startActivity(intent)
            }

            val Cekstatus : ImageButton = findViewById(R.id.cekStatus)
            Cekstatus.setOnClickListener{
                val openURL= Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("http://ppid.sleman.bawaslu.go.id/list/1/cek-status-permohonan-informasi/")

                startActivity(openURL)

            }

            val WA : ImageButton = findViewById(R.id.CS)
            WA.setOnClickListener{
                val openURL=Intent(Intent.ACTION_VIEW)
                //openurl ke web
                openURL.data= Uri.parse("wa.me/+628112632284")
            }

        }
}
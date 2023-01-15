package com.example.eppidbawaslu

import android.content.AsyncQueryHandler
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide.init
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.eppidbawaslu.databinding.ActivityMainBinding
import java.text.FieldPosition
import kotlin.math.abs

class Home : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList : ArrayList<Int>
    private lateinit var adapter :ImageAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_home)

            val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
            val imageSlider2 = findViewById<ImageSlider>(R.id.imageSlider2)
            val imageList = ArrayList<SlideModel>()
            val imagelist2 = ArrayList<SlideModel>()

            imageList.add(SlideModel(R.drawable.regulasi))
            imageList.add(SlideModel(R.drawable.profibawaslu))
            imageSlider.setImageList(imageList, ScaleTypes.FIT)

            val Regulasi : Button = findViewById(R.id.imageSlider)
            Regulasi.setOnClickListener {
                val openURL= Intent(Intent.ACTION_VIEW)
                //openurl ke web
                openURL.data= Uri.parse("https://drive.google.com/file/d/1ZqAhCm_8_VyhN6e1Ffyov5XPvv-c9hsT/view")
                startActivity(openURL)
            }
            imagelist2.add(SlideModel(R.drawable.standarlayanan))
            imagelist2.add(SlideModel(R.drawable.informasilayanan))
            imagelist2.add(SlideModel(R.drawable.informasipublik))
            imageSlider2.setImageList(imagelist2, ScaleTypes.FIT)
            init()
            setUpTransformer()

            viewPager2.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int){
                    super.onPageSelected(position)
                    handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable, 2000)
                }
            })


            val StandarSOP : ImageButton =findViewById(R.id.SOP)
            StandarSOP.setOnClickListener{
                val intent = Intent(this@Home, SOP::class.java)
                startActivity(intent)
            }
            val Form : ImageButton = findViewById(R.id.formpermohonan)
            Form.setOnClickListener{
                val intent = Intent(this@Home, Form_Permohonan_Informasi::class.java)
                startActivity(intent)
            }

            val Cekstatus : ImageButton = findViewById(R.id.cekStatus)
            Cekstatus.setOnClickListener{
                val openURL= Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("http://ppid.sleman.bawaslu.go.id/list/1/cek-status-permohonan-informasi/")
                startActivity(openURL)

            }

            val CS : ImageButton = findViewById(R.id.CS)
            CS.setOnClickListener{
                val openURL= Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("http://wa.me/+628112632284")
                startActivity(openURL)
            }

        }

    override fun onPause(){
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable{
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer{ page, position ->
            val r = 1 - abs (position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2 = findViewById(R.id.slider)
    }


    private  fun init(){
        viewPager2 = findViewById(R.id.slider)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.regulasi)
        imageList.add(R.drawable.regulasi)
        imageList.add(R.drawable.regulasi)

        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

}
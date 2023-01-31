package com.example.eppidbawaslu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
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

        imagelist2.add(SlideModel(R.drawable.standarlayanan))
        imagelist2.add(SlideModel(R.drawable.informasilayanan))
        imagelist2.add(SlideModel(R.drawable.informasipublik))
        imageSlider2.setImageList(imagelist2, ScaleTypes.FIT)

        imageSlider.setOnClickListener(object : ItemClickListener, OnClickListener {
            override fun onItemSelected(position: Int) {
                if (position == 0){
                    Toast.makeText(this@Home, "Klik Gambar 1", Toast.LENGTH_LONG).show()
                }else if (position == 1){
                    Toast.makeText(this@Home, "Klik Gambar 2", Toast.LENGTH_LONG).show()
                }
            }

            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }


        })

        init()
        setUpTransformer()

//        val listView = findViewById<ListView>(R.id.ListView)
//        val list = mutableListOf<ImageData>()
//
//        listView.adapter = AdapterClick(this, com.denzcoskun.imageslider.R.layout.pager_row, list)
//        list.add(ImageData(R.drawable.regulasi))
//        list.add(ImageData(R.drawable.profibawaslu))
//
//        listView.setOnItemClickListener { parent:AdapterView<*>, view:View, position:Int, id:Long ->
//            if (position == 0){
//                Toast.makeText(this@Home,"Yey! di klik :), regulasi", Toast.LENGTH_LONG).show()
//            }
//            if (position == 1){
//                Toast.makeText(this@Home,"Yey! di klik :), Profil Bawaslu", Toast.LENGTH_LONG).show()
//            }
//        }
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

        imageList.add(R.drawable.infolain)
        imageList.add(R.drawable.infolain)
        imageList.add(R.drawable.infolain)

        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

}


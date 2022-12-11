package com.example.eppidbawaslu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SOP : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var adapter : AdapterRecyclerView

    class AdapterRecyclerView {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sop)
    }


}
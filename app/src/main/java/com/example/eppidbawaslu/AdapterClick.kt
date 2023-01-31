package com.example.eppidbawaslu

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import java.util.*

class AdapterClick (var mCtx:Context, var resources: Int, var items:List<ImageData>):ArrayAdapter<ImageData>(mCtx, resources, items){
    //parameter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources, null)

        val imageView :ImageView = view.findViewById(R.id.ListView)

        val mItem:ImageData= items[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        return super.getView(position, convertView, parent)
    }

}

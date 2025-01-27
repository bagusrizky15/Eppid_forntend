package com.example.eppidbawaslu

import android.text.style.ClickableSpan
import android.transition.Slide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ImageAdapter(private val imageList: ArrayList<Int>, private val viewPager2: ViewPager2) :
RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.iv_slider);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_slide, parent, false)
        return ImageViewHolder(view)


    }
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])
        if (position == imageList.size-1){
            viewPager2.post(runnable)
        }

        holder.imageView.setImageResource(imageList[position])

    }

    override fun getItemCount(): Int {
        return imageList.size

    }

    private val runnable = Runnable{
        imageList.addAll(imageList)
    }
}
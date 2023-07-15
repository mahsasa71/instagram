package com.example.instagram3.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import coil.load
import com.example.instagram3.R
import com.example.instagram3.models.Image

class ImagesAdapter (images:List<Image>):PagerAdapter() {
    val imageList=images
    var counter:Int=1

    override fun getCount(): Int {
        return imageList.size

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object`as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageData=imageList.get(position)
       val view:View=LayoutInflater.from(container.context).inflate(R.layout.image_row,null)

        val imageView=view.findViewById<AppCompatImageView>(R.id.image_slider)
        val url="http://mobilemasters.ir/apps/instagram/images/${imageData.img}"
        imageView.load(url){
            error(R.mipmap.ic_launcher)
        }

   Log.e("imageprofile${counter++}",url)
        container.addView(view)
        return view
    }
}
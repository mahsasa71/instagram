package com.example.instagram3.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

import coil.load
import coil.transform.CircleCropTransformation
import com.example.instagram.util.Constance
import com.example.instagram3.R
import com.example.instagram3.models.Post

class PostsAdapter (list: List<Post>): RecyclerView.Adapter<PostsAdapter.PostsVH>() {
    var postlist=list

    class PostsVH(itemView: View) :RecyclerView.ViewHolder(itemView){
        val imgProfile=itemView.findViewById<AppCompatImageView>(R.id.img_profile)
        val txtUsername =itemView.findViewById<AppCompatTextView>(R.id.txt_username)
        val viewPager =itemView.findViewById<ViewPager>(R.id.view_pager)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsVH {
        var view:View=LayoutInflater.from(parent.context).inflate(R.layout.posts_row,null)
        return PostsVH(view)

    }

    override fun onBindViewHolder(holder: PostsVH, position: Int) {

        val post=postlist.get(position)
        holder.txtUsername.setText(post.userName)
        Log.e("","")
        holder.imgProfile.load("${Constance.BASE_URL}${post.imageProfile}"){
            transformations(CircleCropTransformation())
        }
        holder.viewPager.adapter=ImagesAdapter(post.images)

    }

    override fun getItemCount(): Int {
        return postlist.size
    }


}
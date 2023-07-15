package com.example.instagram3.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.instagram.util.Constance
import com.example.instagram3.R
import com.example.instagram3.models.Post

class MyPostsAdapter (val posts: List<Post>):RecyclerView.Adapter<MyPostsAdapter.MyPostsVH>(){
    val postLists=posts
    class MyPostsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_Post=itemView.findViewById<AppCompatImageView>(R.id.img_post)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostsVH {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.my_posts,null)
        return MyPostsVH(view)

    }

    override fun onBindViewHolder(holder: MyPostsVH, position: Int) {
        val post = postLists.get(position)
        val url="http://mobilemasters.ir/apps/instagram/images/${post.images.get(0).img}"
        holder.img_Post.load(url)
    }

    override fun getItemCount(): Int {
        return postLists.size

    }

}
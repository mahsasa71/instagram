package com.example.instagram3.repository

import androidx.lifecycle.MutableLiveData
import com.example.instagram.api.ApiService
import com.example.instagram.api.Iservice
import com.example.instagram3.models.Posts
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostsRepository {
    private   var  mutablePosts: MutableLiveData<Posts> = MutableLiveData<Posts>()

    companion object{

        val instance=PostsRepository()
    }
    fun getPosts(userId:String,from:Int,to:Int): MutableLiveData<Posts>
    {
        val iService:Iservice= ApiService.retrofit.create(Iservice::class.java)
        GlobalScope.launch {
            val response =iService.getMyPosts (userId,from,to)
            mutablePosts.postValue(response.body())
        }
        return mutablePosts
    }
}
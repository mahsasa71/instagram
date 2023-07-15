package com.example.instagram3.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagram.api.ApiService
import com.example.instagram.api.Iservice
import com.example.instagram3.models.Posts
import com.example.instagram3.models.UserInformation
import com.example.instagram3.repository.PostsRepository
import com.example.instagram3.repository.ProfileRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel:ViewModel() {
    private lateinit var mutableList : MutableLiveData<Posts>

    fun getPosts (): MutableLiveData<Posts>{
        mutableList= MutableLiveData<Posts>()
        loadPosts()
        return mutableList
    }
    private fun loadPosts(){
        var iService:Iservice=ApiService.retrofit.create(Iservice::class.java)
        iService.getPosts().enqueue(object :Callback<Posts>{
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
             mutableList.value=response.body()

            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
            }

        })

    }

    private val repository: PostsRepository = PostsRepository.instance
    fun myPosts(userId:String,from:Int,to:Int):MutableLiveData<Posts> =repository.getPosts (userId,from,to)





}
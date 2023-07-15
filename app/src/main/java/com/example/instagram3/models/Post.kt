package com.example.instagram3.models

import com.google.gson.annotations.SerializedName

data class Post(
    val comments:String,
    val description:String,
    val id:Int,
    val imageProfile:String,
    @SerializedName("images")
    val images:List<Image>,
    val likes:Int,
    val userId:Int,
    @SerializedName("username")
    val userName:String

)


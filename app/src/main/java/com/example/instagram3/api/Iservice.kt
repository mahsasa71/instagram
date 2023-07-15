package com.example.instagram.api



import com.example.instagram3.models.Posts
import com.example.instagram3.models.LoginModel
import com.example.instagram3.models.UserInformation
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.*

interface Iservice {
    @POST("login.php")
   @FormUrlEncoded
    fun login(@Field("username")user:String,@Field("password")pass:String): Call<LoginModel>

    @POST("login.php")
    @FormUrlEncoded
    suspend fun loginUser(@Field("username")user:String,@Field("password")pass:String): Response<LoginModel>


    @GET("posts.php")
   fun getPosts(): Call<Posts>
    @POST("user_information.php")
    @FormUrlEncoded
   suspend fun getUserInformation (@Field("id")  id:String):Response<UserInformation>


    @POST("myPosts.php")
    @FormUrlEncoded
   suspend fun getMyPosts(@Field("id")userId:String,
                          @Field("from") from:Int,
                          @Field("to") to:Int): Response<Posts>


}
package com.example.instagram. ui.login

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagram.api.ApiService
import com.example.instagram.api.Iservice
import com.example.instagram3.models.LoginModel
import com.example.instagram3.models.State
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel (application: Application) :AndroidViewModel(application) {
    var app=application
    lateinit var mutableList: MutableLiveData<LoginModel>
    lateinit var mutableLoginState:MutableLiveData<Boolean>

    fun login( username:String,password:String):MutableLiveData<LoginModel>{
        mutableList= MutableLiveData()
        loginUser(username,password)
        return mutableList
    }
    fun loginUser (username:String,password:String){


        var iservice=ApiService.retrofit.create(Iservice::class.java)


        GlobalScope.launch {
           val response= iservice.loginUser(username,password)
            if (response.body()!=null){
            saveLoginState(true, response.body()!!.user.id)
                mutableList.postValue(response.body())

            }

        }





//        iservice.login(username,password).enqueue(object :Callback<LoginModel>{
//            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
//                if (response.body()?.data!!.state  == State.SUCCESS.state){
//                    saveLoginState(true)
//
//                }
//
//                mutableList.value=response.body()
//
//            }
//
//            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
//            }
//
//        })

    }

 fun isLogin (): MutableLiveData<Boolean>{
     mutableLoginState= MutableLiveData()
     var pref:SharedPreferences=app.getSharedPreferences("setting",Context.MODE_PRIVATE)
     var state=pref.getBoolean("state",false)
     mutableLoginState.value=state
     //return state
     return mutableLoginState

 }
    private fun saveLoginState(state:Boolean, userId:String){
        var pref:SharedPreferences=app.getSharedPreferences("setting",Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor=pref.edit()
        editor.putBoolean("state",state)
        editor.putString("userId",userId)
        editor.commit()
    }


}
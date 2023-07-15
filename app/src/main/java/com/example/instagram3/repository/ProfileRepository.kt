package com.example.instagram3.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instagram.api.ApiService
import com.example.instagram.api.Iservice
import com.example.instagram3.models.UserInformation
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileRepository() {

    private   var  mutableProfile: MutableLiveData<UserInformation> = MutableLiveData<UserInformation>()

    companion object{

        val instance=ProfileRepository()
    }

  //  val getUserInformation:MutableLiveData<UserInformation>?
//    get(){
//        var iservice= ApiService.retrofit.create(Iservice::class.java)
//       GlobalScope.launch {
//           val response =iservice.getUserInformation(userId)
//           mutableProfile?.postValue(response.body())
//        }
//
//
//        return mutableProfile
//
//    }
    fun getUserInformation(userId:String): MutableLiveData<UserInformation>
  {
      var iservice= ApiService.retrofit.create(Iservice::class.java)
      GlobalScope.launch {
          val response =iservice.getUserInformation(userId)
           mutableProfile?.postValue(response.body())
        }
      return mutableProfile
    }




}
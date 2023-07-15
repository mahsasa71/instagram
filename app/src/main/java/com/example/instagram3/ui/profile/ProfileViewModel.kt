package com.example.instagram3.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagram3.models.UserInformation
import com.example.instagram3.repository.ProfileRepository

class ProfileViewModel():ViewModel() {
    private val repository:ProfileRepository=ProfileRepository.instance

fun profileUser(userId:String):MutableLiveData<UserInformation> =repository.getUserInformation(userId)
}
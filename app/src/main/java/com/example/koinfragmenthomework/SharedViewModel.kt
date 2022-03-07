package com.example.koinfragmenthomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinfragmenthomework.domain.models.User

class SharedViewModel : ViewModel() {

    val user : LiveData<User> get() = _user
    private val _user = MutableLiveData<User>()

    fun putUser(user: User){
        _user.value = user
    }


}
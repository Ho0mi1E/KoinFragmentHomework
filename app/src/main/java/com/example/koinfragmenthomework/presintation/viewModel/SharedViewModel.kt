package com.example.koinfragmenthomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinfragmenthomework.domain.models.CheckBox
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.domain.models.User

class SharedViewModel : ViewModel() {

    val user: LiveData<User> get() = _user
    private val _user = MutableLiveData<User>()

    val operationSystem: LiveData<GeneralItem> get() = _os
    private val _os = MutableLiveData<GeneralItem>()

    val monitor: LiveData<GeneralItem> get() = _monitor
    private val _monitor = MutableLiveData<GeneralItem>()

    val graphic: LiveData<GeneralItem> get() = _graphic
    private val _graphic = MutableLiveData<GeneralItem>()

    val per: LiveData<CheckBox> get() = _per
    private val _per = MutableLiveData<CheckBox>()

    fun putUser(user: User) {
        _user.value = user
    }

    fun putOS(os: GeneralItem) {
        _os.value = os
    }

    fun putMonitor(monitor: GeneralItem) {
        _monitor.value = monitor
    }

    fun putCheckBox(checkBox: CheckBox) {
        _per.value = checkBox
    }

    fun putGraphic(graphic: GeneralItem) {
        _graphic.value = graphic
    }
}
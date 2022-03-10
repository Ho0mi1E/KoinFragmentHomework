package com.example.koinfragmenthomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinfragmenthomework.domain.models.*

class SharedViewModel : ViewModel() {

    val user: LiveData<User> get() = _user
    private val _user = MutableLiveData<User>()

    val operationSystem: LiveData<OsForView> get() = _os
    private val _os = MutableLiveData<OsForView>()

    val monitor: LiveData<MonitorForView> get() = _monitor
    private val _monitor = MutableLiveData<MonitorForView>()

    val graphic: LiveData<GraphicCardForView> get() = _graphic
    private val _graphic = MutableLiveData<GraphicCardForView>()

    val per: LiveData<CheckBox> get() = _per
    private val _per = MutableLiveData<CheckBox>()

    fun putUser(user: User) {
        _user.value = user
    }

    fun putOS(os: OsForView) {
        _os.value = os
    }

    fun putMonitor(monitor: MonitorForView) {
        _monitor.value = monitor
    }

    fun putCheckBox(checkBox: CheckBox) {
        _per.value = checkBox
    }

    fun putGraphic(graphic: GraphicCardForView) {
        _graphic.value = graphic
    }
}
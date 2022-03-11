package com.example.koinfragmenthomework.presintation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinfragmenthomework.domain.models.*
import com.example.koinfragmenthomework.domain.models.forView.GraphicCardForView
import com.example.koinfragmenthomework.domain.models.forView.MonitorForView
import com.example.koinfragmenthomework.domain.models.forView.OsForView

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

    val count: LiveData<Int> get() = _count
    private val _count = MutableLiveData<Int>()

    val info: LiveData<String> get() = _info
    private val _info = MutableLiveData("")


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
    fun putInt(int: Int){
        _count.value=int
    }

    fun putInfo(info: String){
        _info.value += "$info "
    }
    fun removeInfo(info: String){
        _info.value?.replace("$info ","")
    }
    fun cleanInfo(){
        _info.value = ""
    }




}
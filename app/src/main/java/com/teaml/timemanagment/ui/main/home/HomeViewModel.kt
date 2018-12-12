package com.teaml.timemanagment.ui.main.home

import androidx.lifecycle.LiveData
import com.teaml.timemanagment.data.TaskRepository
import com.teaml.timemanagment.ui.base.BaseViewModel
import com.teaml.timemanagment.utils.SingleLiveEvent
import javax.inject.Inject

class HomeViewModel @Inject constructor(val repository: TaskRepository) : BaseViewModel() {

    private val _onAddTaskClick = SingleLiveEvent<Any>()

    val onAddTaskClick: LiveData<Any> =
        _onAddTaskClick

    fun onAddTaskClick() {
        _onAddTaskClick.call()
    }
}
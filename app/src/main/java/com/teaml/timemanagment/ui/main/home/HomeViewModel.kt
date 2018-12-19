package com.teaml.timemanagment.ui.main.home

import androidx.lifecycle.LiveData
import com.teaml.timemanagment.data.TaskRepository
import com.teaml.timemanagment.ui.base.BaseViewModel
import com.teaml.timemanagment.utils.SingleLiveEvent
import javax.inject.Inject

class HomeViewModel @Inject constructor(repository: TaskRepository) : BaseViewModel() {

    private val _onAddTaskClickEvent = SingleLiveEvent<Any>()
    val onAddTaskClickEvent: LiveData<Any> =
        _onAddTaskClickEvent
    
    private val _onNavigationClickEvent = SingleLiveEvent<Any>()
    val onNavigationClickEvent: LiveData<Any> = 
            _onNavigationClickEvent

    val tasks = repository.loadTasks()


    fun onAddTaskClick() {
        _onAddTaskClickEvent.call()
    }

    fun onNavigationClick() {
        _onNavigationClickEvent.call()
    }

}
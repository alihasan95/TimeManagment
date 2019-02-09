package com.teaml.mytasks.ui.main.home

import androidx.lifecycle.LiveData
import com.teaml.mytasks.data.TaskRepository
import com.teaml.mytasks.ui.base.BaseViewModel
import com.teaml.mytasks.utils.SingleLiveEvent
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: TaskRepository) : BaseViewModel() {

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

    fun deleteTask(taskId: Int) {
        repository.deleteTask(taskId)
    }
}
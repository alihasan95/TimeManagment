package com.teaml.timemanagment.ui.main.add

import com.teaml.timemanagment.data.TaskRepository
import com.teaml.timemanagment.data.local.db.converters.Priority
import com.teaml.timemanagment.data.model.db.Task
import com.teaml.timemanagment.ui.base.BaseViewModel
import javax.inject.Inject

class AddViewModel @Inject constructor(private val taskRepository: TaskRepository)
    : BaseViewModel() {

    fun addTask(title: String, priority: Priority) {
        if (title.isNotEmpty()) {
            taskRepository.addTask(Task(title, priority))
        }
    }
}
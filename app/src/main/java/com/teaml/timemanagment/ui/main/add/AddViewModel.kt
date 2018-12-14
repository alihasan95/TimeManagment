package com.teaml.timemanagment.ui.main.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.teaml.timemanagment.data.TaskRepository
import com.teaml.timemanagment.data.local.db.converters.Priority
import com.teaml.timemanagment.data.model.db.Task
import com.teaml.timemanagment.ui.base.BaseViewModel
import javax.inject.Inject

class AddViewModel @Inject constructor(private val taskRepository: TaskRepository) :
    BaseViewModel() {

    private val taskIdLiveData = MutableLiveData<Int>()
    private var isDelete = false

    val taskLiveData: LiveData<Task> = Transformations.switchMap(taskIdLiveData) { taskId ->
        taskRepository.loadTaskById(taskId)
    }

    fun addTask(title: String, priority: Priority, taskId: Int) {
        // Flag isDelete used to prevent add task again when fragment is destroy
        if (title.isNotEmpty() && isDelete.not()) {
            taskRepository.addTask(Task(title, priority, taskId))
        }
    }

    fun loadTask(taskId: Int) {
        if (taskId != 0) {
            taskIdLiveData.value = taskId
        }
    }

    fun deleteTask(taskId: Int) {
        isDelete = true
        taskRepository.deleteTask(taskId)
    }
}
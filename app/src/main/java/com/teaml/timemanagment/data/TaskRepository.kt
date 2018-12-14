package com.teaml.timemanagment.data

import androidx.lifecycle.LiveData
import com.teaml.timemanagment.data.local.db.converters.Priority
import com.teaml.timemanagment.data.local.db.dao.TaskDao
import com.teaml.timemanagment.data.local.prefs.PreferencesHelper
import com.teaml.timemanagment.data.model.db.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TaskRepository @Inject constructor(
    private val taskDao: TaskDao,
    private val pref: PreferencesHelper
) {

    fun loadTasks(): LiveData<List<Task>> = taskDao.loadTasks()

    fun loadTaskById(taskId: Int): LiveData<Task> = taskDao.loadTaskById(taskId)

    fun addTask(task: Task) = runBlocking(Dispatchers.IO) {
        taskDao.insert(task)
    }

    fun deleteTask(taskId: Int) = runBlocking(Dispatchers.IO) {
        taskDao.delete(Task("", Priority.LOW, taskId))
    }
}
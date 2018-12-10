package com.teaml.timemanagment.data

import androidx.lifecycle.LiveData
import com.teaml.timemanagment.data.local.db.dao.TaskDao
import com.teaml.timemanagment.data.local.prefs.PreferencesHelper
import com.teaml.timemanagment.data.model.db.Task
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataRepository @Inject constructor(
    val taskDao: TaskDao,
    val pref: PreferencesHelper
) {

    fun loadTasks(): LiveData<List<Task>> {
        return taskDao.loadTasks()
    }

}
package com.teaml.timemanagment.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.teaml.timemanagment.data.model.db.Task

@Dao
interface TaskDao : BaseDao<Task> {

    @Query("SELECT * FROM task ORDER BY priority DESC")
    fun loadTasks(): LiveData<List<Task>>

}
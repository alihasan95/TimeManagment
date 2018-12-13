package com.teaml.timemanagment.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.teaml.timemanagment.data.model.db.Task

@Dao
interface TaskDao : BaseDao<Task> {

    @Query("SELECT * FROM task ORDER BY priority, task_id DESC")
    fun loadTasks(): LiveData<List<Task>>

    @Delete
    suspend fun delete(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

}
package com.teaml.timemanagment.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teaml.timemanagment.data.model.db.Task

@Dao
interface TaskDao : BaseDao<Task> {

    @Query("SELECT * FROM task ORDER BY priority, task_id DESC")
    fun loadTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE task_id = :taskId")
    fun loadTaskById(taskId: Int): Task

    @Delete
    suspend fun delete(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tasks: List<Task>)

}
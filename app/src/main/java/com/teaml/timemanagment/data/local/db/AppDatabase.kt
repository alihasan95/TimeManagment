package com.teaml.timemanagment.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teaml.timemanagment.data.local.db.dao.TaskDao
import com.teaml.timemanagment.data.model.db.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao
}
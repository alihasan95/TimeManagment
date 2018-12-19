package com.teaml.mytasks.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.teaml.mytasks.data.local.db.converters.PriorityTypeConverters
import com.teaml.mytasks.data.local.db.dao.TaskDao
import com.teaml.mytasks.data.model.db.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(PriorityTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}
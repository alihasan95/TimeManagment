package com.teaml.timemanagment.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.teaml.timemanagment.data.local.db.converters.PriorityTypeConverters
import com.teaml.timemanagment.data.local.db.dao.TaskDao
import com.teaml.timemanagment.data.model.db.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(PriorityTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}
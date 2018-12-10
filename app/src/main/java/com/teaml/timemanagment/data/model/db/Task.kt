package com.teaml.timemanagment.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "task_id") val taskId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "priority") val priority: Int
)
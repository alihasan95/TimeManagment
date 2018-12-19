package com.teaml.mytask.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teaml.mytask.data.local.db.converters.Priority


@Entity(tableName = "task")
data class Task(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "priority") val priority: Priority,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "task_id") val taskId: Int = 0
)
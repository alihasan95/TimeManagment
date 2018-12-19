package com.teaml.mytasks.data.local.db.converters

import androidx.room.TypeConverter

class PriorityTypeConverters {

    @TypeConverter
    fun priorityToInt(priority: Priority): Int {
        return Priority.valueOf(priority.name).ordinal
    }

    @TypeConverter
    fun intToPriority(index: Int): Priority {
        return Priority.values()[index]
    }
}

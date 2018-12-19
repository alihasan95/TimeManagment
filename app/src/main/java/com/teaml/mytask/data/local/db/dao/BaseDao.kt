package com.teaml.mytask.data.local.db.dao

import androidx.room.Dao

@Dao
interface BaseDao<T> {

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: T)*/


}
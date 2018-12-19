package com.teaml.mytasks.data

import androidx.arch.core.executor.testing.CountingTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.teaml.mytasks.data.local.db.AppDatabase
import com.teaml.mytasks.data.local.db.converters.Priority
import com.teaml.mytasks.data.model.db.Task
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.TimeUnit

abstract class DbTest {

    @Rule
    @JvmField
    val countingTaskExecutorRule = CountingTaskExecutorRule()

    private lateinit var _appDb: AppDatabase
    val appDb: AppDatabase
        get() = _appDb

    companion object {
        const val DEFAULT_TASK_SIZE = 4
    }

    @Before
    fun initDb() {
        _appDb = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            AppDatabase::class.java
        ).build()

        addMockDataToDatabase()
    }

    private fun addMockDataToDatabase() = runBlocking {
        val tasks = listOf(
            Task("taskLow", Priority.LOW),
            Task("taskNormal", Priority.NORMAL),
            Task("taskHigh", Priority.HIGH),
            Task("taskVeryHigh", Priority.VERY_HIGH)
        )

        // Insert tasks
        _appDb.taskDao().insertAll(tasks)
    }

    @After
    fun closeDb() {
        // drainTasks: Waits until all active tasks are finished.
        countingTaskExecutorRule.drainTasks(10, TimeUnit.SECONDS)
        _appDb.close()
    }
}
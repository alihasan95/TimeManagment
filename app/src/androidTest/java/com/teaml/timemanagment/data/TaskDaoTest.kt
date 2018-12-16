package com.teaml.timemanagment.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.runner.AndroidJUnit4
import com.teaml.timemanagment.data.local.db.converters.Priority
import com.teaml.timemanagment.data.model.db.Task
import com.teaml.timemanagment.util.getValue
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TaskDaoTest : DbTest() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getAllTasks() {
        val tasks = getValue(appDb.taskDao().loadTasks())
        assertThat(tasks.size, equalTo(DEFAULT_TASK_SIZE))
    }


    @Test
    fun orderOfTasks() {

        // When
        val tasks = getValue(appDb.taskDao().loadTasks())

        // Then
        // Test order of tasks
        assertThat(tasks[0].title, `is`("taskVeryHigh"))
        assertThat(tasks[1].title, `is`("taskHigh"))
        assertThat(tasks[2].title, `is`("taskNormal"))
        assertThat(tasks[3].title, `is`("taskLow"))
    }

    @Test
    fun getTaskById() {
        // When
        val task = getValue(appDb.taskDao().loadTaskById(1))
        // Then
        assertThat(task.taskId, `is`(1))
        assertThat(task.title, `is`("taskLow"))

    }

    @Test
    fun onConflictInsert() = runBlocking {
        // When
        appDb.taskDao().insert(Task("conflictTask", Priority.VERY_HIGH, 1))
        val tasks = getValue(appDb.taskDao().loadTasks())

        // Then
        assertThat(tasks.size, `is`(DEFAULT_TASK_SIZE))
    }

    @Test
    fun deleteTask() = runBlocking {
        // Given
        val taskDao = appDb.taskDao()
        val task = Task("delete", Priority.LOW, 5)

        // When
        taskDao.insert(task)
        taskDao.delete(task)

        // Then
        val tasksAfterDelete = getValue(taskDao.loadTasks())
        assertThat(tasksAfterDelete.size, equalTo(DEFAULT_TASK_SIZE))
    }

}
package com.teaml.timemanagment.data.converters

import com.teaml.timemanagment.data.local.db.converters.Priority
import com.teaml.timemanagment.data.local.db.converters.PriorityTypeConverters
import org.hamcrest.core.Is.`is`
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PriorityTypeConvertersTest {

    val priority = Priority.LOW
    val intValue = 3

    @Test
    fun priorityToInt() {
        assertThat(PriorityTypeConverters().priorityToInt(priority), `is`(intValue))
    }

    @Test
    fun intToPriority() {
        assertThat(PriorityTypeConverters().intToPriority(intValue), `is`(priority))
    }
}

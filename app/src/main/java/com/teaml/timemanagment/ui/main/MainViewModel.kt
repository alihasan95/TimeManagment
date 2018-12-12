package com.teaml.timemanagment.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import com.teaml.timemanagment.data.TaskRepository
import com.teaml.timemanagment.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val taskRepository: TaskRepository)
    : BaseViewModel() {

}

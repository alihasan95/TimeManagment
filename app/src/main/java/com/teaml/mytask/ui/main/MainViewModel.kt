package com.teaml.mytask.ui.main

import com.teaml.mytask.data.TaskRepository
import com.teaml.mytask.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val taskRepository: TaskRepository)
    : BaseViewModel() {

}

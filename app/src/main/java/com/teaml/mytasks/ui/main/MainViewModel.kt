package com.teaml.mytasks.ui.main

import com.teaml.mytasks.data.TaskRepository
import com.teaml.mytasks.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val taskRepository: TaskRepository)
    : BaseViewModel() {

}

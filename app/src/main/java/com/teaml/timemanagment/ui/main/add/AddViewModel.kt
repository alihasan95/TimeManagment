package com.teaml.timemanagment.ui.main.add

import com.teaml.timemanagment.data.TaskRepository
import com.teaml.timemanagment.ui.base.BaseViewModel
import javax.inject.Inject

class AddViewModel @Inject constructor(private val taskRepository: TaskRepository)
    : BaseViewModel() {

}
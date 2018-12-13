package com.teaml.timemanagment.ui.main.home

import com.teaml.timemanagment.data.local.db.converters.Priority
import com.teaml.timemanagment.data.model.db.Task
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun provideRvHomeAdapter(): RvHomeAdapter {
        //val list = mutableListOf(Task(1, "first task", Priority.HIGH))
        //return RvHomeAdapter(list)
        return RvHomeAdapter(mutableListOf())
    }
}
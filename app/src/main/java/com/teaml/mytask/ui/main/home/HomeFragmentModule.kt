package com.teaml.mytask.ui.main.home

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
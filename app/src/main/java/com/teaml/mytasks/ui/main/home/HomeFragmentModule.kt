package com.teaml.mytasks.ui.main.home

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun provideRvHomeAdapter(context: Context): RvHomeAdapter {
        //val list = mutableListOf(Task(1, "first task", Priority.HIGH))
        //return RvHomeAdapter(list)
        return RvHomeAdapter(context, mutableListOf())
    }
}
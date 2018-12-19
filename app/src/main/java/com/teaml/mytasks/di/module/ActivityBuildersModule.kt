package com.teaml.mytasks.di.module

import com.teaml.mytasks.ui.main.MainActivity
import com.teaml.mytasks.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}
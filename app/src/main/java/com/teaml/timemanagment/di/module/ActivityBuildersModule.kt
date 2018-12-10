package com.teaml.timemanagment.di.module

import com.teaml.timemanagment.ui.main.MainActivity
import com.teaml.timemanagment.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}
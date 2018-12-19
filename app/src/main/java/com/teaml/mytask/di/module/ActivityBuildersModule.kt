package com.teaml.mytask.di.module

import com.teaml.mytask.ui.main.MainActivity
import com.teaml.mytask.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}
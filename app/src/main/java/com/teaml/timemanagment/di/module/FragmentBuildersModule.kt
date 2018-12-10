package com.teaml.timemanagment.di.module

import com.teaml.timemanagment.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = [])
    abstract fun contributeMainFragment(): MainFragment

}
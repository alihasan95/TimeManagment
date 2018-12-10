package com.teaml.timemanagment.di.module

import com.teaml.timemanagment.ui.main.home.HomeFragment
import com.teaml.timemanagment.ui.main.home.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

}
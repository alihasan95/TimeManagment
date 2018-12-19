package com.teaml.mytask.di.module

import com.teaml.mytask.ui.main.about.AboutFragment
import com.teaml.mytask.ui.main.about.AboutFragmentModule
import com.teaml.mytask.ui.main.add.AddFragment
import com.teaml.mytask.ui.main.add.AddFragmentModule
import com.teaml.mytask.ui.main.home.HomeFragment
import com.teaml.mytask.ui.main.home.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [AddFragmentModule::class])
    abstract fun contributeAddFragment(): AddFragment

    @ContributesAndroidInjector(modules = [AboutFragmentModule::class])
    abstract fun contributeAboutFragment(): AboutFragment

}
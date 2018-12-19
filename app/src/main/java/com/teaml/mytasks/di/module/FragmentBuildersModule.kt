package com.teaml.mytasks.di.module

import com.teaml.mytasks.ui.main.about.AboutFragment
import com.teaml.mytasks.ui.main.about.AboutFragmentModule
import com.teaml.mytasks.ui.main.add.AddFragment
import com.teaml.mytasks.ui.main.add.AddFragmentModule
import com.teaml.mytasks.ui.main.home.HomeFragment
import com.teaml.mytasks.ui.main.home.HomeFragmentModule
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
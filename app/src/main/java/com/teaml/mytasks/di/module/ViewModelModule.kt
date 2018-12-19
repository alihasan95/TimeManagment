package com.teaml.mytasks.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teaml.mytasks.TaskViewModelFactory
import com.teaml.mytasks.di.custom.ViewModelKey
import com.teaml.mytasks.ui.main.MainViewModel
import com.teaml.mytasks.ui.main.about.AboutViewModel
import com.teaml.mytasks.ui.main.add.AddViewModel
import com.teaml.mytasks.ui.main.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddViewModel::class)
    abstract fun bindAddViewModel(addViewModel: AddViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindAboutViewModel(aboutViewModel: AboutViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: TaskViewModelFactory): ViewModelProvider.Factory
}
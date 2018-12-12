package com.teaml.timemanagment.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teaml.timemanagment.TaskViewModelFactory
import com.teaml.timemanagment.di.custom.ViewModelKey
import com.teaml.timemanagment.ui.main.MainViewModel
import com.teaml.timemanagment.ui.main.add.AddViewModel
import com.teaml.timemanagment.ui.main.home.HomeViewModel
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
    abstract fun bindViewModelFactory(factory: TaskViewModelFactory): ViewModelProvider.Factory
}
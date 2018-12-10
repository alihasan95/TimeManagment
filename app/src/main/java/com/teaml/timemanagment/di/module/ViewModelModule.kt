package com.teaml.timemanagment.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teaml.timemanagment.TimeViewModelFactory
import com.teaml.timemanagment.di.custom.ViewModelKey
import com.teaml.timemanagment.ui.main.MainViewModel
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
    abstract fun bindViewModelFactory(factory: TimeViewModelFactory): ViewModelProvider.Factory
}
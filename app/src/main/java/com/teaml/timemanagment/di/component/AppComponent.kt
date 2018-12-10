package com.teaml.timemanagment.di.component

import com.teaml.timemanagment.TaskApp
import com.teaml.timemanagment.di.module.ActivityBuildersModule
import com.teaml.timemanagment.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBuildersModule::class])
interface AppComponent : AndroidInjector<TaskApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TaskApp>()
}
package com.teaml.mytask.di.component

import com.teaml.mytask.TaskApp
import com.teaml.mytask.di.module.ActivityBuildersModule
import com.teaml.mytask.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class,
    ActivityBuildersModule::class])
interface AppComponent : AndroidInjector<TaskApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TaskApp>()
}
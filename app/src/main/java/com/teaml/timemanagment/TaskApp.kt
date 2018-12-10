package com.teaml.timemanagment

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TaskApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
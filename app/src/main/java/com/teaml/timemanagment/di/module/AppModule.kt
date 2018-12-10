package com.teaml.timemanagment.di.module

import android.content.Context
import androidx.room.Room
import com.teaml.timemanagment.TaskApp
import com.teaml.timemanagment.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app : TaskApp): Context {
        return app.applicationContext
    }

   /* @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        // TODO Use AppConstants later
        return Room.databaseBuilder(context, AppDatabase::class.java, "tasks").build()
    }*/
}
package com.teaml.mytask.di.module

import android.content.Context
import androidx.room.Room
import com.teaml.mytask.TaskApp
import com.teaml.mytask.data.local.db.AppDatabase
import com.teaml.mytask.data.local.db.dao.TaskDao
import com.teaml.mytask.data.local.prefs.AppPreferencesHelper
import com.teaml.mytask.data.local.prefs.PreferencesHelper
import com.teaml.mytask.di.custom.PreferencesInfo
import com.teaml.mytask.utils.AppConstants.APP_DB_NAME
import com.teaml.mytask.utils.AppConstants.PREF_FILE_NAME
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

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, APP_DB_NAME).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(appDatabase: AppDatabase): TaskDao {
        return appDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @PreferencesInfo
    fun providePreferencesFileName(): String {
        return PREF_FILE_NAME
    }
}
package com.teaml.mytasks.di.module

import android.content.Context
import androidx.room.Room
import com.teaml.mytasks.TaskApp
import com.teaml.mytasks.data.local.db.AppDatabase
import com.teaml.mytasks.data.local.db.dao.TaskDao
import com.teaml.mytasks.data.local.prefs.AppPreferencesHelper
import com.teaml.mytasks.data.local.prefs.PreferencesHelper
import com.teaml.mytasks.di.custom.PreferencesInfo
import com.teaml.mytasks.utils.AppConstants.APP_DB_NAME
import com.teaml.mytasks.utils.AppConstants.PREF_FILE_NAME
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
package com.teaml.timemanagment.di.module

import android.content.Context
import androidx.room.Room
import com.teaml.timemanagment.TaskApp
import com.teaml.timemanagment.data.local.db.AppDatabase
import com.teaml.timemanagment.data.local.prefs.AppPreferencesHelper
import com.teaml.timemanagment.data.local.prefs.PreferencesHelper
import com.teaml.timemanagment.di.custom.PreferencesInfo
import com.teaml.timemanagment.utils.AppConstants.APP_DB_NAME
import com.teaml.timemanagment.utils.AppConstants.PREF_FILE_NAME
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
        // TODO Use AppConstants later
        return Room.databaseBuilder(context, AppDatabase::class.java, APP_DB_NAME).build()
    }

    @Provides
    @Singleton
    fun providePreferncesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @PreferencesInfo
    fun providePreferncesFileName(): String {
        return PREF_FILE_NAME
    }
}
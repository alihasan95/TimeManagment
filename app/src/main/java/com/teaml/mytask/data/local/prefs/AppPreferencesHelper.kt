package com.teaml.mytask.data.local.prefs

import android.content.Context
import com.teaml.mytask.di.custom.PreferencesInfo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppPreferencesHelper @Inject constructor(
    context: Context,
    @PreferencesInfo prefFileName: String
) : PreferencesHelper {


    private companion object {

    }

}
package com.teaml.timemanagment.utils.extension

import android.content.res.Resources
import timber.log.Timber

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

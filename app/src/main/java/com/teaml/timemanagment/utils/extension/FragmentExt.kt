package com.teaml.timemanagment.utils.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> Fragment.obtainViewModel(factory: ViewModelProvider.Factory? = null): T {
    return ViewModelProviders.of(this, factory).get(T::class.java)
}
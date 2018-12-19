package com.teaml.mytasks.utils

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {

    val TAG: String = SingleLiveEvent::class.java.simpleName
    private val pending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        if (hasActiveObservers()) {
            Log.e(TAG, "Multiple observers registered but only one will be notified of changes")
        }

        super.observe(owner, Observer {
            if(pending.compareAndSet(true, false))
                observer.onChanged(it)
        })
    }

    @MainThread
    override fun setValue(value: T?) {
        pending.set(true)
        super.setValue(value)
    }

    override fun postValue(value: T?) {
        pending.set(true)
        super.postValue(value)
    }

    @MainThread
    fun call() {
        value = null
    }

}
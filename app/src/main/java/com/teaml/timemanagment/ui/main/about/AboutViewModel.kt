package com.teaml.timemanagment.ui.main.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import com.teaml.timemanagment.ui.base.BaseViewModel
import com.teaml.timemanagment.utils.AppConstants
import com.teaml.timemanagment.utils.SingleLiveEvent
import javax.inject.Inject

class AboutViewModel @Inject constructor() : BaseViewModel() {

    private val _followAsLiveData = SingleLiveEvent<Any>()
    val followAsLiveData: LiveData<Any>
        get() = _followAsLiveData

    fun onTelegramIconClick() {
        _followAsLiveData.value = AppConstants.TELEGRAM_CHANNEL
    }

    fun onFacebookIconClick() {
        _followAsLiveData.value = AppConstants.FACEBOOK_PAGE_LINK
    }
}

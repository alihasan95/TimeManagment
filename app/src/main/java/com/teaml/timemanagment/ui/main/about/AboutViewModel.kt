package com.teaml.timemanagment.ui.main.about

import androidx.lifecycle.LiveData
import com.teaml.timemanagment.ui.base.BaseViewModel
import com.teaml.timemanagment.utils.AppConstants
import com.teaml.timemanagment.utils.SingleLiveEvent
import javax.inject.Inject

class AboutViewModel @Inject constructor() : BaseViewModel() {
    private val _linksLiveData = SingleLiveEvent<String>()
    val linksLiveData: LiveData<String>
        get() = _linksLiveData

    fun onTelegramIconClick() {
        _linksLiveData.value = AppConstants.TELEGRAM_CHANNEL
    }

    fun onFacebookIconClick() {
        _linksLiveData.value = AppConstants.FACEBOOK_PAGE_LINK
    }


}

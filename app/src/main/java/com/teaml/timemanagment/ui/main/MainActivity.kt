package com.teaml.timemanagment.ui.main

import androidx.lifecycle.ViewModelProviders
import com.teaml.timemanagment.BR
import com.teaml.timemanagment.R
import com.teaml.timemanagment.databinding.MainActivityBinding
import com.teaml.timemanagment.ui.base.BaseActivity

class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    private val mainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.main_activity

    override fun getViewModel(): MainViewModel = mainViewModel


}

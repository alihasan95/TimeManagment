package com.teaml.timemanagment.ui.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.teaml.timemanagment.BR
import com.teaml.timemanagment.R
import com.teaml.timemanagment.databinding.MainActivityBinding
import com.teaml.timemanagment.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    @Inject
    lateinit var viewModelProviders: ViewModelProvider.Factory

    private val mainViewModel by lazy {
        ViewModelProviders.of(this, viewModelProviders).get(MainViewModel::class.java)
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.main_activity

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

}

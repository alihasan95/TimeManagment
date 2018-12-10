package com.teaml.timemanagment.ui.base

import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : DaggerFragment() {


    protected lateinit var viewDataBinding: ViewDataBinding
    private var baseActivity: BaseActivity<*, *>? = null

    /**
     * override to set layout resource
     * @return layout resource id
     */
    abstract fun getLayoutRes(): Int

    /**
     * override to set viewModel
     * @return viewModel instance
     */
    abstract fun getViewModel(): V


    fun hideKeyboard() {
        baseActivity?.hideKeyboard()
    }
}
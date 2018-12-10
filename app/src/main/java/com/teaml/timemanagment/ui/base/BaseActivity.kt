package com.teaml.timemanagment.ui.base

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : DaggerAppCompatActivity() {

    protected lateinit var binding: T
    private var viewModel: V? = null

    /**
     * override to set dataBinding variable
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    /**
     * override to set layout resource
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * override to set layout resource
     * @return viewModel instance
     */
    abstract fun getViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        val viewModel = viewModel ?: getViewModel()
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()
    }

    fun hideKeyboard() {
        val view = currentFocus
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0 )
    }

}
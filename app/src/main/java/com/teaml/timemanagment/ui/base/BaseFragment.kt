package com.teaml.timemanagment.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : DaggerFragment() {


    protected lateinit var binding: T
    private lateinit var viewModel: V
    protected var baseActivity: BaseActivity<*, *>? = null

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

    /**
     * override to set dataBinding variable
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            baseActivity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()
    }

    override fun onDestroyView() {
        baseActivity?.hideKeyboard()
        super.onDestroyView()
    }
}
package com.teaml.timemanagment.ui.main.home


import com.teaml.timemanagment.BR
import com.teaml.timemanagment.R
import com.teaml.timemanagment.databinding.FragmentHomeBinding
import com.teaml.timemanagment.ui.base.BaseFragment
import com.teaml.timemanagment.utils.extension.obtainViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val homeViewModel by lazy {
        obtainViewModel<HomeViewModel>()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun getViewModel(): HomeViewModel = homeViewModel

    override fun getBindingVariable(): Int = BR.viewModel


}

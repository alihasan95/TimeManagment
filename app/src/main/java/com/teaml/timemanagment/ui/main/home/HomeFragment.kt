package com.teaml.timemanagment.ui.main.home


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.teaml.timemanagment.BR
import com.teaml.timemanagment.R
import com.teaml.timemanagment.databinding.FragmentHomeBinding
import com.teaml.timemanagment.ui.base.BaseFragment
import com.teaml.timemanagment.utils.extension.observe
import com.teaml.timemanagment.utils.extension.obtainViewModel
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: RvHomeAdapter

    private val homeViewModel by lazy {
        obtainViewModel<HomeViewModel>(viewModelProvider)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun getViewModel(): HomeViewModel = homeViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(context!!)
        binding.recyclerView.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        subscribeUi()
    }

    private fun subscribeUi() {
        observe(homeViewModel.onAddTaskClick) {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
    }


}

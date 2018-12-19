package com.teaml.timemanagment.ui.main.home


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.teaml.timemanagment.BR
import com.teaml.timemanagment.R
import com.teaml.timemanagment.databinding.FragmentHomeBinding
import com.teaml.timemanagment.ui.base.BaseFragment
import com.teaml.timemanagment.ui.main.bottomsheet.BottomNavigationDrawerDialogFragment
import com.teaml.timemanagment.utils.SpaceItemDecoration
import com.teaml.timemanagment.utils.extension.observe
import com.teaml.timemanagment.utils.extension.obtainViewModel
import javax.inject.Inject

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


        binding.recyclerView.addItemDecoration(SpaceItemDecoration())

        adapter.setOnItemClickListener { taskId ->

            val actionHomeFragmentToAddFragment =
                HomeFragmentDirections.actionHomeFragmentToAddFragment()
            actionHomeFragmentToAddFragment.setTaskId(taskId)
            findNavController().navigate(actionHomeFragmentToAddFragment)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // setup navigation controller
        baseActivity?.setSupportActionBar(binding.bar)


        binding.bar.setNavigationOnClickListener { homeViewModel.onNavigationClick() }

        subscribeUi()
    }

    private fun subscribeUi() {
        observe(homeViewModel.onAddTaskClickEvent) {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }

        observe(homeViewModel.onNavigationClickEvent) {
            val bottomNavigationViewDialogFragment =
                BottomNavigationDrawerDialogFragment.newInstance()

            bottomNavigationViewDialogFragment.show(
                baseActivity?.supportFragmentManager!!,
                BottomNavigationDrawerDialogFragment.TAG
            )
        }

        observe(homeViewModel.tasks) { tasks ->
            tasks?.let { adapter.addTasks(it) }
        }
    }

}

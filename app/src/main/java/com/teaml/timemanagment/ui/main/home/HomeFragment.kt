package com.teaml.timemanagment.ui.main.home


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.teaml.timemanagment.BR
import com.teaml.timemanagment.R
import com.teaml.timemanagment.databinding.FragmentHomeBinding
import com.teaml.timemanagment.ui.base.BaseFragment
import com.teaml.timemanagment.ui.main.homemenu.BottomNavigationViewDialogFragment
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(binding.bar)


        binding.bar.setNavigationOnClickListener {
            val bottomNavigationViewDialogFragment = BottomNavigationViewDialogFragment()
            bottomNavigationViewDialogFragment.show(
                appCompatActivity.supportFragmentManager,
                BottomNavigationViewDialogFragment.TAG
            )
        }

        subscribeUi()
    }

    private fun subscribeUi() {
        observe(homeViewModel.onAddTaskClick) {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }

        observe(homeViewModel.tasks) { tasks ->
            tasks?.let { adapter.addTasks(it) }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        NavigationUI.onNavDestinationSelected(item, findNavController())
                || super.onOptionsItemSelected(item)
}

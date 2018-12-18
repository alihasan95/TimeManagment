package com.teaml.timemanagment.ui.main.add


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.teaml.timemanagment.BR
import com.teaml.timemanagment.R
import com.teaml.timemanagment.data.local.db.converters.Priority
import com.teaml.timemanagment.data.local.db.converters.PriorityTypeConverters
import com.teaml.timemanagment.data.model.db.Task
import com.teaml.timemanagment.databinding.FragmentAddBinding
import com.teaml.timemanagment.ui.base.BaseFragment
import com.teaml.timemanagment.utils.extension.observe
import com.teaml.timemanagment.utils.extension.obtainViewModel
import kotlinx.android.synthetic.main.toolbar.view.*
import timber.log.Timber
import javax.inject.Inject


class AddFragment : BaseFragment<FragmentAddBinding, AddViewModel>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private val addViewModel by lazy {
        obtainViewModel<AddViewModel>(viewModelProvider)
    }

    private var taskId: Int = 0
    private var title = ""
    private var priority = Priority.VERY_HIGH

    override fun getLayoutRes(): Int = R.layout.fragment_add

    override fun getViewModel(): AddViewModel = addViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        AddFragmentArgs.fromBundle(arguments).apply {
            this@AddFragment.taskId = taskId
            addViewModel.loadTask(taskId)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {

        val priorityAdapter = ArrayAdapter.createFromResource(
            context!!,
            R.array.priority, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        )
        binding.prioritySpinner.adapter = priorityAdapter
        binding.prioritySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        priority = PriorityTypeConverters().intToPriority(position)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}

                }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // setup navigation controller
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(binding.toolbarLayout.toolbar)
        appCompatActivity.setupActionBarWithNavController(findNavController())


        subscribe()
    }


    private fun subscribe() {
        observe(addViewModel.taskLiveData) { task ->
            task?.let {
                binding.titleEdit.setText(it.title)
                binding.prioritySpinner.setSelection(
                    PriorityTypeConverters().priorityToInt(it.priority)
                )
            }
        }
    }

    override fun onDestroyView() {
        title = binding.titleEdit.text.toString()
        super.onDestroyView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (taskId != 0) {
            inflater.inflate(R.menu.menu_add_task, menu)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroy() {
        addViewModel.addTask(title, priority, taskId)
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_delete_task -> {

            addViewModel.deleteTask(taskId)
            findNavController().navigateUp()
            true
        }

        else -> super.onOptionsItemSelected(item)

    }
}

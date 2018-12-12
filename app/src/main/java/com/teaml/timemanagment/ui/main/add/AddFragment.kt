package com.teaml.timemanagment.ui.main.add


import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.teaml.timemanagment.BR
import com.teaml.timemanagment.R
import com.teaml.timemanagment.data.local.db.converters.PriorityTypeConverters
import com.teaml.timemanagment.data.model.db.Task
import com.teaml.timemanagment.databinding.FragmentAddBinding
import com.teaml.timemanagment.ui.base.BaseFragment
import com.teaml.timemanagment.utils.extension.obtainViewModel
import javax.inject.Inject


class AddFragment : BaseFragment<FragmentAddBinding, AddViewModel>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private val addViewModel by lazy {
        obtainViewModel<AddViewModel>(viewModelProvider)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_add

    override fun getViewModel(): AddViewModel = addViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setup()

    }

    private fun setup() {
        // setup navigation controller
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(binding.toolbar)
        appCompatActivity.setupActionBarWithNavController(findNavController())


        val priorityAdapter = ArrayAdapter.createFromResource(context!!,
                R.array.priority, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        binding.prioritySpinner.adapter = priorityAdapter


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

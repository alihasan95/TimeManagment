package com.teaml.mytasks.ui.main.about

import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.teaml.mytasks.R
import com.teaml.mytasks.databinding.FragmentAboutBinding
import com.teaml.mytasks.ui.base.BaseFragment
import com.teaml.mytasks.utils.extension.observe
import com.teaml.mytasks.utils.extension.obtainViewModel
import org.jetbrains.anko.browse
import javax.inject.Inject

class AboutFragment : BaseFragment<FragmentAboutBinding, AboutViewModel>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private val aboutViewModel by lazy {
        obtainViewModel<AboutViewModel>(viewModelProvider)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_about

    override fun getViewModel(): AboutViewModel = aboutViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // setup navigation controller
        baseActivity?.apply {
            setSupportActionBar(binding.toolbarLayout.toolbar)
            setupActionBarWithNavController(findNavController())
        }

        observe(aboutViewModel.linksLiveData) { link ->
            link?.let { baseActivity?.browse(link, true) }
        }
    }

}

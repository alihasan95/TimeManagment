package com.teaml.timemanagment.ui.main.about

import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import com.teaml.timemanagment.R
import com.teaml.timemanagment.databinding.FragmentAboutBinding
import com.teaml.timemanagment.ui.base.BaseFragment
import com.teaml.timemanagment.utils.extension.observe
import com.teaml.timemanagment.utils.extension.obtainViewModel
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

        observe(aboutViewModel.linksLiveData) { link ->
            link?.let { baseActivity?.browse(link, true) }
        }
    }

}

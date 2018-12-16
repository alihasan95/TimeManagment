package com.teaml.timemanagment.ui.main.about

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider

import com.teaml.timemanagment.R
import com.teaml.timemanagment.databinding.AboutFragmentBinding
import com.teaml.timemanagment.ui.base.BaseFragment
import com.teaml.timemanagment.utils.extension.observe
import com.teaml.timemanagment.utils.extension.obtainViewModel
import org.jetbrains.anko.browse
import javax.inject.Inject

class AboutFragment : BaseFragment<AboutFragmentBinding,AboutViewModel>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private val aboutViewModel by lazy {
        obtainViewModel<AboutViewModel>(viewModelProvider)
    }

    override fun getLayoutRes(): Int = R.layout.about_fragment

    override fun getViewModel(): AboutViewModel = aboutViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(aboutViewModel.followAsLiveData) {
            activity?.browse(it.toString(), true)
        }
    }


}

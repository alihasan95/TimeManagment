package com.teaml.mytasks.ui.main.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.teaml.mytasks.R
import com.teaml.mytasks.databinding.FragmentBottomNavigationDrawerBinding
import com.teaml.mytasks.ui.base.RoundedBottomSheetDialogFragment
import com.teaml.mytasks.utils.AppConstants
import org.jetbrains.anko.browse

class BottomNavigationDrawerDialogFragment : RoundedBottomSheetDialogFragment() {

    companion object {
        val TAG: String = BottomNavigationDrawerDialogFragment::class.java.simpleName

        fun newInstance() = BottomNavigationDrawerDialogFragment()
    }

    private lateinit var binding: FragmentBottomNavigationDrawerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomNavigationDrawerBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            dismiss()
            when(menuItem.itemId) {
                R.id.action_view_source_code -> { activity?.browse(
                    AppConstants.SOURCE_CODE_LINK,
                    true
                )}
            }
            NavigationUI.onNavDestinationSelected(menuItem, findNavController())
        }
    }


}
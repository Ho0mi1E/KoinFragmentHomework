package com.example.koinfragmenthomework.presintation.fragments

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.domain.models.forView.OsForView
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.bottomfragment.BottomFragment

import com.example.koinfragmenthomework.presintation.viewModel.OSViewModel
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_oc.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class OSFragment : Fragment(R.layout.fragment_oc) {
    companion object {
        const val TAG = "OC"
        fun newInstance() = OSFragment()
    }

    private val viewModel: OSViewModel by viewModel()

    private val sharedViewModel: SharedViewModel by sharedViewModel()


    private val bond = object : Bonding<OsForView> {
        override fun bonding(item: OsForView) {
            editOC.setText(item.info)
        }
    }

    override fun onStart() {
        super.onStart()
        openBottom()
        openFragmentGraphicCard()
    }

    private fun openBottom() {
        val fragment = BottomFragment(viewModel, bond)
        editOC.setOnClickListener {
            fragment.show(requireActivity().supportFragmentManager, BottomFragment.TAG)
        }
    }

    private fun openFragmentGraphicCard() {
        btnOs.setOnClickListener {
            if (editOC.text.isEmpty()) {
                showToast("Выберите OS")
            } else {
                sharedViewModel.putOS(OsForView(editOC.text.toString()))
                requireActivity().apply {
                    openFragment(
                        CountCardFragment.TAG,
                        R.id.container,
                        CountCardFragment.newInstance()
                    )
                }
            }
        }
    }
}
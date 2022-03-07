package com.example.koinfragmenthomework.presintation.fragment

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.data.OSRepositoryImpl
import com.example.koinfragmenthomework.domain.interatorsImpl.OSInteractorImpl
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.bottomfragment.BottomFragment
import com.example.koinfragmenthomework.presintation.viewModel.OSViewModel
import kotlinx.android.synthetic.main.fragment_oc.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class OCFragment : Fragment(R.layout.fragment_oc) {
    companion object{
        const val TAG = "OC"
        fun newInstance() = OCFragment()
    }

    private val viewModel by lazy { OSViewModel(OSInteractorImpl(OSRepositoryImpl)) }
    private val bond = object : Bonding {
        override fun bonding(item: GeneralItem) {
            editOC.setText(item.info)
        }
    }

    override fun onStart() {
        super.onStart()
        openBottom()

    }

    private fun openBottom(){
        val fragment = BottomFragment(viewModel,bond)
        editOC.setOnClickListener {
            fragment.show(requireActivity().supportFragmentManager,BottomFragment.TAG)
        }
    }




}
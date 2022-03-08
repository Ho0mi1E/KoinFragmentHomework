package com.example.koinfragmenthomework.presintation.fragments

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.bottomfragment.BottomFragment
import com.example.koinfragmenthomework.presintation.viewModel.GraphicViewModel
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_graphic.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GraphicFragment : Fragment(R.layout.fragment_graphic) {
    companion object {
        const val TAG = "GRAPHIC"
        fun newInstance() = GraphicFragment()
    }

    private val bond = object : Bonding {
        override fun bonding(item: GeneralItem) {
            editGraphic.setText(item.info)
        }
    }
    private val viewModel: GraphicViewModel by viewModel()

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()
        openBottom()
        openFragmentGraphicCard()
    }

    private fun openBottom() {
        val fragment = BottomFragment(viewModel, bond)
        editGraphic.setOnClickListener {
            fragment.show(requireActivity().supportFragmentManager, BottomFragment.TAG)
        }
    }

    private fun openFragmentGraphicCard() {
        btnGraphic.setOnClickListener {
            if (editGraphic.text.isEmpty()) {
                showToast("Выберите Видеокарту")
            } else {
                sharedViewModel.putGraphic(GeneralItem(editGraphic.text.toString()))
                requireActivity().apply {
                    openFragment(MonitorFragment.TAG, R.id.container, MonitorFragment.newInstance())
                }
            }
        }
    }
}
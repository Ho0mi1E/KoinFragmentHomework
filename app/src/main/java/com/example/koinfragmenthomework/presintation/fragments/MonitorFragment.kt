package com.example.koinfragmenthomework.presintation.fragments

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.domain.models.MonitorForView
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.bottomfragment.BottomFragment
import com.example.koinfragmenthomework.presintation.viewModel.MonitorViewModel
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_monitor.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MonitorFragment : Fragment(R.layout.fragment_monitor) {
    companion object {
        const val TAG = "MONITOR"
        fun newInstance() = MonitorFragment()
    }

    private val bond = object : Bonding<MonitorForView> {
        override fun bonding(item: MonitorForView) {
            editMonitor.setText(item.info)
        }
    }

    private val viewModel: MonitorViewModel by viewModel()

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()
        openBottom()
        openFragmentPeripherals()
    }

    private fun openBottom() {
        editMonitor.setOnClickListener {
            val fragment = BottomFragment(viewModel, bond)
            fragment.show(requireActivity().supportFragmentManager, BottomFragment.TAG)
        }
    }

    private fun openFragmentPeripherals() {
        btnMonitor.setOnClickListener {
            if (editMonitor.text.isEmpty()) {
                showToast("Выберите Монитор")
            } else {
                sharedViewModel.putMonitor(MonitorForView(editMonitor.text.toString()))
                requireActivity().apply {
                    openFragment(PerFragment.TAG, R.id.container, PerFragment.newInstance())

                }
            }
        }
    }
}
package com.example.koinfragmenthomework.presintation.fragments

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_count_card.*
import kotlinx.android.synthetic.main.fragment_count_monitor.*

import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CountMonitorFragment : Fragment(R.layout.fragment_count_monitor) {

    companion object {
        const val TAG = "COUNTMONITOR"
        fun newInstance() = CountMonitorFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()
        validationMonitor()
    }

    private fun validationMonitor() {

        btnCountMonitor.setOnClickListener {
            if (editCountMonitor.text.isEmpty() || editCountMonitor.text.toString()
                    .toInt() < 1 || editCountMonitor.text.toString().toInt() > 4
            ) {
                showToast("Выберите от 1 до 4, пожалуйста")
            } else {
                sharedViewModel.putInt(editCountMonitor.text.toString().toInt())
                requireActivity().apply {
                    openFragment(MonitorFragment.TAG, R.id.container, MonitorFragment.newInstance())
                }
            }
            sharedViewModel.cleanInfo()
        }
    }
}
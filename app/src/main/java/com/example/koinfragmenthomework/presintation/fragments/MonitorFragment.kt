package com.example.koinfragmenthomework.presintation.fragments

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.domain.models.forView.MonitorForView
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.presintation.recycler.edit.AdapterRecyclerEdit
import com.example.koinfragmenthomework.presintation.viewModel.MonitorViewModel
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_monitor.*
import kotlinx.android.synthetic.main.recycler_patern_edit.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MonitorFragment : Fragment(R.layout.fragment_monitor) {
    companion object {
        const val TAG = "MONITOR"
        fun newInstance() = MonitorFragment()
    }


    private val viewModel: MonitorViewModel by viewModel()

    private val adapter by lazy { AdapterRecyclerEdit(this, viewModel, sharedViewModel) }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()
        openRecycler()
        openFragmentPeripherals()
    }


    private fun openRecycler() {
        sharedViewModel.count.observe(viewLifecycleOwner) { count ->
            adapter.submit("Монитор", count)
        }
        recyclerEditMonitor.adapter = adapter
    }


    private fun openFragmentPeripherals() {
        btnMonitor.setOnClickListener {
            if (editRecycler.text.isEmpty()) {
                showToast("Выберите Монитор")
            } else {
                sharedViewModel.info.observe(viewLifecycleOwner) { info ->
                    sharedViewModel.putMonitor(MonitorForView(info))
                }
                requireActivity().apply {
                    openFragment(PerFragment.TAG, R.id.container, PerFragment.newInstance())
                }
            }
        }
    }
}
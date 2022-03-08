package com.example.koinfragmenthomework.presintation.bottomfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.recycler.AdapterRecycler
import com.example.koinfragmenthomework.presintation.viewModel.OSViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class BottomFragment<E : OSViewModel>(private val viewModel: E, bond: Bonding) :
    BottomSheetDialogFragment() {
    companion object {
        const val TAG = "BOTTOM"
    }

    private val adapter by lazy { AdapterRecycler(bonded) }

    private val bonded by lazy {
        object : Bonding {
            override fun bonding(item: GeneralItem) {
                dismiss()
                bond.bonding(item)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    override fun onStart() {
        super.onStart()
        viewModel.data.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
        recycler.adapter = adapter
    }
}
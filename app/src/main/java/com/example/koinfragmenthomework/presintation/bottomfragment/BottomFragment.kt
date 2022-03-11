package com.example.koinfragmenthomework.presintation.bottomfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.domain.models.forView.CommonClass
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.recycler.text.AdapterRecyclerText
import com.example.koinfragmenthomework.presintation.viewModel.CommonViewModel
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*
import org.koin.androidx.viewmodel.ext.android.sharedStateViewModel


class BottomFragment<out E : CommonViewModel<T>, T : CommonClass>(
    private val viewModel: E,
    bond: Bonding<T>
) :
    BottomSheetDialogFragment() {
    companion object {
        const val TAG = "BOTTOM"
    }

    private val sharedViewModel: SharedViewModel by sharedStateViewModel()

    private val adapter by lazy { AdapterRecyclerText(bonded, sharedViewModel) }

    private val bonded by lazy {
        object : Bonding<T> {
            override fun bonding(item: T) {
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
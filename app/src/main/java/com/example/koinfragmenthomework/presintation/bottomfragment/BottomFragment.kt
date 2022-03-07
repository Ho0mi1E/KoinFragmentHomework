package com.example.koinfragmenthomework.presintation.bottomfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.data.OSRepositoryImpl
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.recycler.AdapterRecycler
import com.example.koinfragmenthomework.presintation.viewModel.OSViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class BottomFragment (private val  viewModel: OSViewModel, bond: Bonding) : BottomSheetDialogFragment() {
    companion object{
        const val TAG = "BOTTOM"

    }

    private val recycler by lazy { requireActivity().findViewById<RecyclerView>(R.id.container) }

    private val adapter by lazy {AdapterRecycler(bond = bonding)}
    private val bonding by lazy {
        object : Bonding {
            override fun bonding(item: GeneralItem) {
                dismiss()
                bond.bonding(item)
            }
        } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recyclerview_patern,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner){list ->
            adapter.submitList(list)
        }
        recycler.adapter = adapter

    }





}
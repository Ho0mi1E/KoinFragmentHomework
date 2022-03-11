package com.example.koinfragmenthomework.presintation.recycler.text

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.domain.models.forView.CommonClass

import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel

class AdapterRecyclerText<E : CommonClass>(
    val bond: Bonding<E>,
    val sharedViewModel: SharedViewModel
) : RecyclerView.Adapter<ViewHolderText<E>>() {

    private var list: List<E> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderText<E> {
        return ViewHolderText.newInstance(parent, bond, sharedViewModel)
    }

    override fun onBindViewHolder(holder: ViewHolderText<E>, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(data: List<E>) {
        list = data
        notifyDataSetChanged()
    }
}
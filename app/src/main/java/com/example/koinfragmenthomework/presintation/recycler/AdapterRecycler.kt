package com.example.koinfragmenthomework.presintation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.domain.models.CommonClass

import com.example.koinfragmenthomework.presintation.bonding.Bonding

class AdapterRecycler<E : CommonClass>(val bond: Bonding<E>) : RecyclerView.Adapter<ShopViewHolder<E>>() {

    private var list: List<E> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder<E> {
        return ShopViewHolder.newInstance(parent, bond)
    }

    override fun onBindViewHolder(holder: ShopViewHolder<E>, position: Int) {
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
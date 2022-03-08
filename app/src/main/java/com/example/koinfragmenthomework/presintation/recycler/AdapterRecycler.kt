package com.example.koinfragmenthomework.presintation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.presintation.bonding.Bonding

class AdapterRecycler(val bond: Bonding) : RecyclerView.Adapter<ShopViewHolder>() {

    private var list: List<GeneralItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        return ShopViewHolder.newInstance(parent, bond)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(data: List<GeneralItem>) {
        list = data
        notifyDataSetChanged()
    }
}
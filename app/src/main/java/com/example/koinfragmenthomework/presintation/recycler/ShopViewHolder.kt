package com.example.koinfragmenthomework.presintation.recycler

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import kotlinx.android.synthetic.main.recyclerview_patern.view.*

class ShopViewHolder(item: View, private val bonding: Bonding) : RecyclerView.ViewHolder(item) {
    companion object {
        fun newInstance(parent: ViewGroup, bonding: Bonding) = ShopViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_patern, parent, false), bonding
        )
    }

    fun bindItem(item: GeneralItem) {
        itemView.textPat.text = item.info
        itemView.root.setOnClickListener {
            bonding.bonding(item)
        }
    }
}
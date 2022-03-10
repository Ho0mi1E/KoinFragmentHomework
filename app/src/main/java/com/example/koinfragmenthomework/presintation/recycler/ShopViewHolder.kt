package com.example.koinfragmenthomework.presintation.recycler

import android.annotation.SuppressLint
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.domain.models.CommonClass
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import kotlinx.android.synthetic.main.recyclerview_patern.view.*

class ShopViewHolder< E : CommonClass>(item: View, private val bonding: Bonding<E>) : RecyclerView.ViewHolder(item) {
    companion object {
        fun <E : CommonClass> newInstance(parent: ViewGroup, bonding: Bonding<E>) = ShopViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_patern, parent, false), bonding
        )
    }

    @SuppressLint("SetTextI18n")
    fun bindItem(item: E) {
        itemView.textPat.text = item.info
        itemView.root.setOnClickListener {
            bonding.bonding(item)
        }
    }
}
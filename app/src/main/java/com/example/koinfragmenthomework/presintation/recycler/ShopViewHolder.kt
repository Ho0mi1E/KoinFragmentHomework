package com.example.koinfragmenthomework.presintation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.domain.models.GeneralItem
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import kotlinx.android.synthetic.main.recyclerview_patern.view.*

class ShopViewHolder(item: View,private val bonding: Bonding) : RecyclerView.ViewHolder(item) {
    companion object{
        fun newInstance(parent: ViewGroup,bonding: Bonding) = ShopViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_patern,parent,false),bonding)
    }

    fun  bindItem(data: GeneralItem){
        itemView.textPat.text = data.info
        itemView.root.setOnClickListener {
            bonding.bonding(data)
        }



    }
}
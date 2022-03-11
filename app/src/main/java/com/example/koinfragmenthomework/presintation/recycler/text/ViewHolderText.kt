package com.example.koinfragmenthomework.presintation.recycler.text

import android.annotation.SuppressLint
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.domain.models.forView.CommonClass
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import kotlinx.android.synthetic.main.recyclerview_patern_text.view.*

class ViewHolderText<E : CommonClass>(
    item: View,
    private val bonding: Bonding<E>,
    val sharedViewModel: SharedViewModel
) : RecyclerView.ViewHolder(item) {
    companion object {
        fun <E : CommonClass> newInstance(
            parent: ViewGroup,
            bonding: Bonding<E>,
            sharedViewModel: SharedViewModel
        ) = ViewHolderText(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_patern_text, parent, false), bonding, sharedViewModel
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
package com.example.koinfragmenthomework.presintation.recycler.edit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.domain.models.forView.CommonClass
import com.example.koinfragmenthomework.presintation.bonding.Bonding
import com.example.koinfragmenthomework.presintation.bottomfragment.BottomFragment
import com.example.koinfragmenthomework.presintation.viewModel.CommonViewModel
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import kotlinx.android.synthetic.main.recycler_patern_edit.view.*


class ViewHolderEdit<E : CommonViewModel<T>, T : CommonClass>(
    item: View,
    val viewModel: E,
    val sharedViewModel: SharedViewModel
) : RecyclerView.ViewHolder(item) {
    companion object {
        const val TAG = "EDIT"
        fun <E : CommonViewModel<T>, T : CommonClass> newInstance(
            parent: ViewGroup,
            viewModel: E,
            sharedViewModel: SharedViewModel
        ) = ViewHolderEdit(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_patern_edit, parent, false
            ), viewModel, sharedViewModel
        )
    }

    private val bond = object : Bonding<T> {
        override fun bonding(item: T) {
            itemView.editRecycler.setText(item.info)
            sharedViewModel.putInfo(item.info)
        }
    }
    private val bottom = BottomFragment(viewModel, bond)


    fun bind(tag: String, fragment: Fragment) {
        itemView.editRecycler.hint = tag
        itemView.editRecycler.setOnClickListener {
            bottom.show(fragment.requireActivity().supportFragmentManager, BottomFragment.TAG)
            sharedViewModel.removeInfo(itemView.editRecycler.text.toString())
        }
    }
}
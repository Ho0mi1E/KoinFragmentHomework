package com.example.koinfragmenthomework.presintation.recycler.edit

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.koinfragmenthomework.domain.models.forView.CommonClass
import com.example.koinfragmenthomework.presintation.viewModel.CommonViewModel
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel

class AdapterRecyclerEdit<E : CommonViewModel<T>, T : CommonClass>(
    val fragment: Fragment,
    val viewModel: E,
    val sharedViewModel: SharedViewModel
) : RecyclerView.Adapter<ViewHolderEdit<E, T>>() {

    private var tag = ""
    private var count = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderEdit<E, T> {
        return ViewHolderEdit.newInstance(parent, viewModel, sharedViewModel)
    }

    override fun onBindViewHolder(holder: ViewHolderEdit<E, T>, position: Int) {
        holder.bind(tag, fragment)

    }

    override fun getItemCount(): Int {
        return count
    }

    fun submit(tag1: String, count1: Int) {
        tag = tag1
        count = count1
        notifyDataSetChanged()
    }
}
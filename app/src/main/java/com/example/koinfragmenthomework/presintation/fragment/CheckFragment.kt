package com.example.koinfragmenthomework.presintation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.SharedViewModel
import kotlinx.android.synthetic.main.fragment_check.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CheckFragment : Fragment(R.layout.fragment_check) {
    companion object{
        const val TAG = "CHECK"
        fun newInstance() = CheckFragment()
    }

    private val viewModel : SharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner){user ->
            textCheck.text = user.name

        }
    }


}
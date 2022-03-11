package com.example.koinfragmenthomework.presintation.fragments

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_count_card.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CountCardFragment : Fragment(R.layout.fragment_count_card) {
    companion object {
        const val TAG = "COUNT"
        fun newInstance() = CountCardFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()


    override fun onStart() {
        super.onStart()
        btnCount.setOnClickListener {
            validationCard()
        }
    }

    private fun validationCard() {

        if (editCount.text.isEmpty() || editCount.text.toString()
                .toInt() < 1 || editCount.text.toString().toInt() > 4
        ) {
            showToast("Выберите от 1 до 4, пожалуйста")
        } else {
            sharedViewModel.putInt(editCount.text.toString().toInt())
            requireActivity().apply {
                openFragment(GraphicFragment.TAG, R.id.container, GraphicFragment.newInstance())
            }
        }
    }
}
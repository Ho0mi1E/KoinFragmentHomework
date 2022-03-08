package com.example.koinfragmenthomework.presintation.fragments

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.domain.models.User
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_data.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DataFragment : Fragment(R.layout.fragment_data) {
    companion object {
        const val TAG = "DATA"
        fun newInstance() = DataFragment()
    }

    private val viewModel: SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()
        btnData.setOnClickListener {
            validation()
        }
    }

    private fun validation() {
        if (editLastName.text.isEmpty()
            || editName.text.isEmpty()
            || editNumber.text.isEmpty()
        ) {
            showToast("Есть незаполненные поля")
        } else {
            if (editNumber.text.toString().length < 10 && editNumber.text.isNotEmpty()) {
                showToast("Невернный номер")
            } else {
                viewModel.putUser(createUser())
                requireActivity().apply {
                    openFragment(OSFragment.TAG, R.id.container, OSFragment.newInstance())
                }
            }
        }
    }

    private fun createUser(): User {
        return User(
            editName.text.toString(),
            editLastName.text.toString(),
            editNumber.text.toString()
        )
    }
}
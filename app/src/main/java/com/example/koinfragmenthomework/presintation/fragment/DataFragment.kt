package com.example.koinfragmenthomework.presintation.fragment

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.SharedViewModel
import com.example.koinfragmenthomework.domain.models.User
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.showToast
import kotlinx.android.synthetic.main.fragment_data.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DataFragment : Fragment(R.layout.fragment_data) {
    companion object{
        const val TAG = "DATA"
        fun newInstance() = DataFragment()
    }

    private val viewModel : SharedViewModel by sharedViewModel()

    override fun onStart() {
        super.onStart()
        dataBtn.setOnClickListener {
            validation()
            viewModel.putUser(createUser())
            requireActivity().apply {
                openFragment(OCFragment.TAG,R.id.container,OCFragment.newInstance())

            }
        }
    }

    private fun validation(){
        if (editLastName.text.isEmpty()
            || editName.text.isEmpty()
            || editNumber.text.isEmpty())
            showToast("Есть не заполненные поля")
        if (editNumber.text.toString().length < 10 && editNumber.text.isNotEmpty())
            showToast("некоректно")
    }

    private fun createUser(): User {
        return User(editName.text.toString(),editLastName.text.toString(),editNumber.text.toString())


    }

}
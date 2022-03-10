package com.example.koinfragmenthomework.presintation.fragments

import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import com.example.koinfragmenthomework.domain.models.CheckBox
import com.example.koinfragmenthomework.openFragment
import kotlinx.android.synthetic.main.fragment_peripherals.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.time.Year

class PerFragment : Fragment(R.layout.fragment_peripherals) {
    companion object {
        const val TAG = "PER"
        const val YES = "Да"
        const val NO = "Нет"
        fun newInstance() = PerFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()


    override fun onStart() {
        super.onStart()

        btnPer.setOnClickListener {
            checkBox()
            requireActivity().openFragment(
                CheckFragment.TAG,
                R.id.container,
                CheckFragment.newInstance()
            )
        }
    }

    private fun checkBox() {
        val keyBoard = if (keyboard.isChecked) YES else NO
        val mouseText = if (mouse.isChecked) YES else NO
        val check = CheckBox(keyBoard, mouseText)
        sharedViewModel.putCheckBox(check)
    }
}
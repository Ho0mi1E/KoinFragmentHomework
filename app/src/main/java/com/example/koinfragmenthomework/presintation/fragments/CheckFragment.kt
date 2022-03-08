package com.example.koinfragmenthomework.presintation.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import android.view.View
import androidx.fragment.app.Fragment
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.presintation.viewModel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_check.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CheckFragment : Fragment(R.layout.fragment_check) {
    companion object {
        const val TAG = "CHECK"
        fun newInstance() = CheckFragment()
    }

    private val viewModel: SharedViewModel by sharedViewModel()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        btnCheck.setOnClickListener {
            val message =
                "Ваш заказ \n" + textInfo.text.toString() + "\n" + textOS.text.toString() + "\n" + textGraphic.text.toString() + "\n" + textMonitor.text.toString() + "\n" + textPer.text.toString() + "\nС вас 40 гривен"
            openApp(message)

        }
    }

    @SuppressLint("SetTextI18n")
    private fun observer() {
        var message = ""
        viewModel.user.observe(viewLifecycleOwner) { user ->
            textInfo.text =
                "Имя: ${user.name}\nФамилия: ${user.secondName}\nНомер телефона: ${user.number} "
            message = textInfo.text.toString() + "\n"
        }
        viewModel.operationSystem.observe(viewLifecycleOwner) { os ->
            textOS.text = "Операционная система : ${os.info}"
            message += textOS.text.toString() + "\n"
        }
        viewModel.graphic.observe(viewLifecycleOwner) { graphic ->
            textGraphic.text = "Видео карта : ${graphic.info}"
            message += textGraphic.text.toString() + "\n"
        }
        viewModel.monitor.observe(viewLifecycleOwner) { monitor ->
            textMonitor.text = "Монитор : ${monitor.info}"
            message += textMonitor.text.toString() + "\n"
        }
        viewModel.per.observe(viewLifecycleOwner) { checkBox ->
            textPer.text = "Клавиатура : ${checkBox.keyBoard}\nМышь : ${checkBox.mouse}"
            message += textPer.text.toString()
        }
    }

    private fun openApp(message: String) {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.type = "text/plain"
        val intentChooser = Intent.createChooser(sendIntent, "Some title")
        startActivity(intentChooser)
    }
}
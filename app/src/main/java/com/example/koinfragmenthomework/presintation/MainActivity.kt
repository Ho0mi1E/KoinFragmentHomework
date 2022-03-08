package com.example.koinfragmenthomework.presintation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koinfragmenthomework.R
import com.example.koinfragmenthomework.openFragment
import com.example.koinfragmenthomework.presintation.fragments.DataFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        openFragment(DataFragment.TAG, R.id.container, DataFragment.newInstance())
    }
}
package com.example.koinfragmenthomework

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.openFragment(tag: String, container: Int, fragment: Fragment){
    supportFragmentManager
        .beginTransaction()
        .replace(container,fragment,tag)
        .addToBackStack(tag)
        .commit()
}

fun Fragment.showToast(message:String){
    Toast
        .makeText(requireContext(),message,Toast.LENGTH_LONG)
        .show()

}
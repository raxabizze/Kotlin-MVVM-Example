package com.example.raxabizze.kotlinmvvmexample.base

import android.support.annotation.StringRes
import android.widget.Toast
import dagger.android.support.DaggerFragment


abstract class BaseFragment : BaseView, DaggerFragment() {

    override fun showToast(@StringRes text: Int) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

}
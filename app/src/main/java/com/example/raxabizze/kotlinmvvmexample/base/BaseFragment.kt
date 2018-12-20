package com.example.raxabizze.kotlinmvvmexample.base

import android.support.annotation.StringRes
import dagger.android.support.DaggerFragment


abstract class BaseFragment : BaseView, DaggerFragment() {

    override fun showProgressDialog(@StringRes text: Int) {

    }

    override fun dismissProgressDialog() {
    }

//    override fun showToast(@StringRes text: Int) {
////        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun showToast(text: String) {
////        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
//    }

}
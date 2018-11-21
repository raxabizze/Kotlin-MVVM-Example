package com.example.raxabizze.kotlinmvvmexample.base

import android.support.annotation.StringRes

interface BaseView {

    fun showProgressDialog(@StringRes text: Int)

    fun dismissProgressDialog()

    fun showToast(text: String)

    fun showToast(@StringRes text: Int)
}
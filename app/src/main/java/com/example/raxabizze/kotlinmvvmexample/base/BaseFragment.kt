package com.example.raxabizze.kotlinmvvmexample.base

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment : BaseView, Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

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
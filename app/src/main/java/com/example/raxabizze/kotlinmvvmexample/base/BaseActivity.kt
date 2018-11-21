package com.example.raxabizze.kotlinmvvmexample.base

import android.os.Bundle
import android.support.annotation.StringRes
import android.widget.Toast
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity : BaseView, DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun showProgressDialog(@StringRes text: Int) {

    }

    override fun dismissProgressDialog() {
    }

    override fun showToast(@StringRes text: Int) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
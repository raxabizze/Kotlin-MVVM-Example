package com.example.raxabizze.kotlinmvvmexample.base

import android.support.annotation.StringRes
import android.widget.Toast
import com.example.raxabizze.kotlinmvvmexample.utils.factory.AppViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity : BaseView, DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

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
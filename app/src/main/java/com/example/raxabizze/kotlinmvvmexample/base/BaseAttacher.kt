package com.example.raxabizze.kotlinmvvmexample.base

interface BaseAttacher<V : BaseView> {

    fun onAttached(view: V)

    fun onDetached()
}
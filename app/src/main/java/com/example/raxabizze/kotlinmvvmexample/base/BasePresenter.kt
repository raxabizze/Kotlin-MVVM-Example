package com.example.raxabizze.kotlinmvvmexample.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : BaseView>: BaseAttacher<V> {

    var mCompositeDisposable: CompositeDisposable? = null

    private var mView: V? = null

    fun getView(): V? = mView

    override fun onAttached(view: V) {
        mView = view
    }

    override fun onDetached() {
        unSubscribe()
        mView = null
    }

    fun addSubscribe(disposable: Disposable) {
        mCompositeDisposable?.let {
            it.add(disposable)
        } ?: run {
            mCompositeDisposable = CompositeDisposable()
        }
    }

    private fun unSubscribe() = mCompositeDisposable?.dispose()
}
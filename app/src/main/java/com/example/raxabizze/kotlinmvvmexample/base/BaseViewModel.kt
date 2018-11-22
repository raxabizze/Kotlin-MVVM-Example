package com.example.raxabizze.kotlinmvvmexample.base

import android.arch.lifecycle.ViewModel
import com.example.raxabizze.kotlinmvvmexample.utils.api.PostApi
import com.example.raxabizze.kotlinmvvmexample.utils.rxjava.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference
import javax.inject.Inject

abstract class BaseViewModel<N> : ViewModel() {

    @Inject
    lateinit var schedulerProvider : SchedulerProvider

    @Inject
    lateinit var mCompositeDisposable: CompositeDisposable

    @Inject
    lateinit var mPostApi: PostApi

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mNavigator: WeakReference<N>? = null

    var navigator: N
        get() = mNavigator!!.get()!!
        set(navigator) {
            this.mNavigator = WeakReference(navigator)
        }

    override fun onCleared() {
        super.onCleared()
        if (!mCompositeDisposable.isDisposed) {
            mCompositeDisposable.dispose()
        }
    }
}
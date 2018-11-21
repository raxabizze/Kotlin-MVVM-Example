package com.example.raxabizze.kotlinmvvmexample.base

import android.arch.lifecycle.ViewModel
import com.example.raxabizze.kotlinmvvmexample.utils.api.PostApi
import com.example.raxabizze.kotlinmvvmexample.utils.rxjava.scheduler.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference
import javax.inject.Inject

abstract class BaseViewModel<N> : ViewModel() {

    lateinit var schedulerProvider : SchedulerProvider

    lateinit var mCompositeDisposable: CompositeDisposable

    lateinit var mPostApi: PostApi

    @Inject
    fun BaseViewModel(mCompositeDisposable: CompositeDisposable, schedulerProvider: SchedulerProvider, mPostApi: PostApi){
        this.mCompositeDisposable = mCompositeDisposable
        this.schedulerProvider = schedulerProvider
        this.mPostApi = mPostApi
    }

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
package com.example.raxabizze.kotlinmvvmexample.ui.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.util.Log
import com.example.raxabizze.kotlinmvvmexample.base.BaseViewModel
import com.example.raxabizze.kotlinmvvmexample.utils.SingleLiveData
import com.example.raxabizze.kotlinmvvmexample.utils.api.pojo.post.Post
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import plusAssign
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel<MainContract.View>() {

    val text = ObservableField("old data")

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Post>>()

    val uiEventLiveData: MutableLiveData<Int> = SingleLiveData()

    fun onLoadPost() {

        /** Retrofit method 1 **/
        isLoading.set(true)
        mCompositeDisposable += mPostApi.getPosts("/todos/")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(object : DisposableObserver<ArrayList<Post>>() {

                    override fun onNext(@NonNull mDataList: ArrayList<Post>) {
                        repositories.value = mDataList
                    }

                    override fun onError(@NonNull e: Throwable) {
                        Log.e("error", e.message)
                    }

                    override fun onComplete() {
                        isLoading.set(false)
                    }
                })


        /** Retrofit method 2
        mCompositeDisposable += mPostApi.getPosts("/todos/")
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(
                { getView()?.onLoadDataSuccess(it) },
                { getView()?.onLoadDataFailure() }
            )
         **/
    }



    // WeakReference or LiveData => https://stackoverflow.com/a/46827625

    /** Start Activity method 1 => WeakReference **/
    fun onStartActivity() {
        navigator.onStartActivity()
    }


    /** Start Activity method 2 => LiveData **/
    fun onStartActivityClick() {
        uiEventLiveData.value = 1
    }

}
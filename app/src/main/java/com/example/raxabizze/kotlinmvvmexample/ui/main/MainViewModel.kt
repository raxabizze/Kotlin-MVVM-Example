package com.example.raxabizze.kotlinmvvmexample.ui.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.example.raxabizze.kotlinmvvmexample.base.BaseViewModel
import com.example.raxabizze.kotlinmvvmexample.room.Posts
import com.example.raxabizze.kotlinmvvmexample.room.PostsDao
import com.example.raxabizze.kotlinmvvmexample.utils.SingleLiveData
import plusAssign
import javax.inject.Inject

class MainViewModel @Inject constructor(var mPostsDao: PostsDao) : BaseViewModel<MainContract.View>() {

    val text = ObservableField("old data")

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<List<Posts>>()

    val uiEventLiveData: MutableLiveData<Int> = SingleLiveData()

    fun onLoadPost() {

        isLoading.set(true)
        mCompositeDisposable += mPostApi.getPosts("/todos/")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.io())
                .doOnTerminate { getData() }
                .subscribe { mPostsDao.insertPosts(*it.toTypedArray()) }
    }

    fun getData() {

        isLoading.set(false)

        mCompositeDisposable += mPostsDao.allPosts
                .observeOn(schedulerProvider.ui())
                .subscribe { repositories.value = (it) }
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
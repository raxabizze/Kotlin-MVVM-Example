package com.example.raxabizze.kotlinmvvmexample.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.raxabizze.kotlinmvvmexample.R
import com.example.raxabizze.kotlinmvvmexample.base.BaseActivity
import com.example.raxabizze.kotlinmvvmexample.core.ActivityLauncher
import com.example.raxabizze.kotlinmvvmexample.room.Posts
import com.example.raxabizze.kotlinmvvmexample.utils.factory.AppViewModelFactory
import com.example.raxabizze.kotlinmvvmexample.utils.toast
import javax.inject.Inject
import com.example.raxabizze.kotlinmvvmexample.databinding.ActivityMainBinding as Binding

class MainActivity :  BaseActivity(), MainContract.View, MainContract.View.OnItemClickListener {
    lateinit var binding: Binding

    private val mAdapter = MainAdapter(arrayListOf(), this)

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onSetUp()
    }

    private fun onSetUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.navigator = this
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.run {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = mAdapter
        }

        viewModel.repositories.observe(this,
                Observer<List<Posts>> { it?.let { mAdapter.replaceData(it) } })

        viewModel.uiEventLiveData.observe(this, Observer {
            when (it) {
                1 -> { ActivityLauncher.go(this, MainActivity::class.java, null) }
                2 -> {  }
            }
        })

        viewModel.getData()
    }

    override fun onItemClick(position: Int) {
        toast("onItemClick")
    }

    override fun onStartActivity() {
        ActivityLauncher.go(this, MainActivity::class.java, null)
    }

}
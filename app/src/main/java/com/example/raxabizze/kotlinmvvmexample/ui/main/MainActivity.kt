package com.example.raxabizze.kotlinmvvmexample.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.raxabizze.kotlinmvvmexample.R
import com.example.raxabizze.kotlinmvvmexample.base.BaseActivity
import com.example.raxabizze.kotlinmvvmexample.core.ActivityLauncher
import com.example.raxabizze.kotlinmvvmexample.room.Posts
import com.example.raxabizze.kotlinmvvmexample.service.MainIntentService
import com.example.raxabizze.kotlinmvvmexample.service.MainIntentService.Companion.ACTION_FOO
import com.example.raxabizze.kotlinmvvmexample.utils.toast
import com.example.raxabizze.kotlinmvvmexample.databinding.ActivityMainBinding as Binding

class MainActivity :  BaseActivity(), MainContract.View, MainContract.View.OnItemClickListener {
    lateinit var binding: Binding

    private val mAdapter = MainAdapter(arrayListOf(), this)

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onSetUp()
        onStartService()
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

    private fun onStartService() {
        val intent = Intent(this, MainIntentService::class.java)
        intent.action = ACTION_FOO
        intent.putExtra(MainIntentService.EXTRA_PARAM1, "EXTRA_PARAM1")
        intent.putExtra(MainIntentService.EXTRA_PARAM2, "EXTRA_PARAM2")
        startService(intent)
    }

    override fun onItemClick(position: Int) {
        toast("onItemClick")
    }

    override fun onStartActivity() {
        ActivityLauncher.go(this, MainActivity::class.java, null)
    }

}
package com.example.raxabizze.kotlinmvvmexample.ui.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.raxabizze.kotlinmvvmexample.R
import com.example.raxabizze.kotlinmvvmexample.base.BaseActivity
import com.example.raxabizze.kotlinmvvmexample.model.Repository
import com.example.raxabizze.kotlinmvvmexample.utils.api.pojo.post.Post
import com.example.raxabizze.kotlinmvvmexample.utils.toast
import javax.inject.Inject
import com.example.raxabizze.kotlinmvvmexample.databinding.ActivityLoginBinding as Binding

class LoginActivity : BaseActivity(), LoginContract.View {

    lateinit var binding: Binding

    @Inject
    lateinit var mRepository : Repository

    @Inject
    internal lateinit var mPresenter: LoginContract.Presenter<LoginContract.View>

    private val mAdapter = LoginAdapter(arrayListOf(), itemClickListener())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onSetUp()
    }

    private fun onSetUp() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.run {
            view = this@LoginActivity
            repository = mRepository
            loading.visibility = View.INVISIBLE
            recyclerView.layoutManager = LinearLayoutManager(this@LoginActivity)
            recyclerView.adapter = mAdapter
        }

        mPresenter.onAttached(this)
    }

    override fun onLoadDataClick() {

        binding.loading.visibility = View.VISIBLE
        mPresenter.onLoadRepositories()
        mRepository.status = "Loading ~"
    }

    override fun onLoadDataFailure() {

        toast("onLoadDataFailure")
        binding.loading.visibility = View.INVISIBLE
        mRepository.status = ""
    }

    override fun onLoadDataSuccess(mDataList: List<Post>) {

        toast("onLoadDataSuccess")
        mAdapter.replaceData(mDataList)
        binding.loading.visibility = View.INVISIBLE
        mRepository.status = ""
    }

    fun itemClickListener() = object: LoginContract.View.OnItemClickListener {

        override fun onItemClick(position: Int) {
            toast("onItemClick position: $position")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDetached()
        super.onDestroy()
    }
}
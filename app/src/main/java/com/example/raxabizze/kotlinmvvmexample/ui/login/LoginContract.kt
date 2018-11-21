package com.example.raxabizze.kotlinmvvmexample.ui.login

import com.example.raxabizze.kotlinmvvmexample.base.BaseAttacher
import com.example.raxabizze.kotlinmvvmexample.base.BaseView
import com.example.raxabizze.kotlinmvvmexample.utils.api.pojo.post.Post

interface LoginContract {

    interface View : BaseView {

        fun onLoadDataClick()

        fun onLoadDataSuccess(mDataList: List<Post>)

        fun onLoadDataFailure()

        interface OnItemClickListener {
            fun onItemClick(position: Int)
        }
    }


    interface Presenter<V : View> : BaseAttacher<V>{

        fun onLoadRepositories()
    }

    interface Adapter {
        fun replaceData(mDataList: List<Post>)
    }
}
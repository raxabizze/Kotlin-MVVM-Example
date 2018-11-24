package com.example.raxabizze.kotlinmvvmexample.ui.main

import com.example.raxabizze.kotlinmvvmexample.base.BaseView
import com.example.raxabizze.kotlinmvvmexample.room.Posts

interface MainContract {

    interface View : BaseView {

        fun onStartActivity()

        interface OnItemClickListener {
            fun onItemClick(position: Int)
        }
    }

    interface Adapter {
        fun replaceData(mDataList: List<Posts>)
    }
}
package com.example.raxabizze.kotlinmvvmexample.utils

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.android.databinding.library.baseAdapters.BR

class ViewHolder<B : ViewDataBinding>(private val mViewDataBinding: B) : RecyclerView.ViewHolder(mViewDataBinding.root) {

//    fun bind(any: Any) {
//        // sr is the data in xml
//        mViewDataBinding.setVariable(BR.sr, any)
//        mViewDataBinding.executePendingBindings()
//    }

}

//class ViewHolder(binding : ItemMainVideoBinding) : RecyclerView.ViewHolder(binding.root) {
//
//    var mItemMainVideoBinding: ItemMainVideoBinding? = null
//    var mItemMainYoutuberBinding: ItemMainYoutuberBinding? = null
//
//
//    constructor(binding: ItemMainYoutuberBinding): this(binding.root) {
//        mItemMainYoutuberBinding = binding
//    }
//
//
//
//
//    fun bind(any1: Any, any2: Any) {
//        // sr is the data in xml
////        mViewDataBinding.setVariable(BR.position, any1)
//        mViewDataBinding.setVariable(BR.sr, any2)
//        mViewDataBinding.executePendingBindings()
//    }
//}
package com.example.raxabizze.kotlinmvvmexample.di.module.base

import android.content.Context
import dagger.Module
import javax.inject.Inject

@Module
class ResourceProvider @Inject constructor(private val mContext: Context) {

    fun getString(resId: Int): String {
        return mContext.getString(resId)
    }

    fun getString(resId: Int, value: String): String {
        return mContext.getString(resId, value)
    }
}
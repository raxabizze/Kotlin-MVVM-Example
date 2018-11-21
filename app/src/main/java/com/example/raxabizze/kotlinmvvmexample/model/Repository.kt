package com.example.raxabizze.kotlinmvvmexample.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.raxabizze.kotlinmvvmexample.BR

class Repository(status : String) : BaseObservable(){

    @get:Bindable
    var status : String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.status)
    }
}
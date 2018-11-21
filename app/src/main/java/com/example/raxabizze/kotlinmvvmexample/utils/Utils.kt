package com.example.raxabizze.kotlinmvvmexample.utils

class Utils {
    fun upperFirstAndLaast (str: String): String {
        val upperFirst = str.substring(0,1).toUpperCase() + str.substring(1)
        return upperFirst.substring(0, upperFirst.length - 1) +
                upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
    }
}
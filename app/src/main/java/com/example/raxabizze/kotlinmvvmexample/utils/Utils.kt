package com.example.raxabizze.kotlinmvvmexample.utils

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.widget.Toolbar


class Utils {
    fun upperFirstAndLaast (str: String): String {
        val upperFirst = str.substring(0,1).toUpperCase() + str.substring(1)
        return upperFirst.substring(0, upperFirst.length - 1) +
                upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
    }

    /** https://stackoverflow.com/a/34613769 */
    fun centerToolbarTitle(@NonNull toolbar: Toolbar) {
        val title = toolbar.title
        val outViews = ArrayList<View>(1)
        toolbar.findViewsWithText(outViews, title, View.FIND_VIEWS_WITH_TEXT)
        if (!outViews.isEmpty()) {
            val titleView = outViews[0] as TextView
            titleView.gravity = Gravity.CENTER
            val layoutParams = titleView.layoutParams as Toolbar.LayoutParams
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            toolbar.requestLayout()
            //also you can use titleView for changing font: titleView.setTypeface(Typeface);
        }
    }
}
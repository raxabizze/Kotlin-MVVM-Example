package com.example.raxabizze.kotlinmvvmexample.utils.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.view.WindowManager
import android.widget.Button
import com.example.raxabizze.kotlinmvvmexample.R
import kotlinx.android.synthetic.main.dialog_library.*


class LibraryDialog(context: Context): DialogInterface.OnCancelListener, View.OnClickListener{
    private val mContext: Context? = null
    private val mResId: Int = 0
    private var mDialog = Dialog(context, R.style.LibraryDialogStyle)
    private var dialog_btn: Button? = null




    fun show(): LibraryDialog {
        mDialog.setContentView(R.layout.dialog_library)
        mDialog.window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT)

        // 點邊取消
        mDialog.setCancelable(true)
        mDialog.setCanceledOnTouchOutside(true)

        mDialog.cancel_btn.setOnClickListener(this)
        mDialog.setOnCancelListener(this)
        mDialog.show()

        return this
    }

    override fun onCancel(dialog: DialogInterface) {
        mDialog.dismiss()
    }

    override fun onClick(v: View) {
        mDialog.dismiss()
    }
}
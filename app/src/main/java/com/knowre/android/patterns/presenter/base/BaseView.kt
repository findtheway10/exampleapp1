package com.knowre.android.patterns.presenter.base

import android.content.DialogInterface

interface BaseView {

    fun makeToast(text: String)

    fun makeToast(res: Int)

    fun makeAlternativeDialog(titleResId: Int,
                              messageResId: Int,
                              negativeResId: Int,
                              positiveResId: Int,
                              negativeListener: DialogInterface.OnClickListener,
                              positiveListener: DialogInterface.OnClickListener)

    fun makeDialog(titleResId: Int,
                   messageResId: Int,
                   positiveResId: Int,
                   positiveListener: DialogInterface.OnClickListener)
}
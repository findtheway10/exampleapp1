package com.knowre.android.patterns.activity.base

import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity: AppCompatActivity() {

    fun makeToast(text: String) {
        Toast.makeText(this, text,  Toast.LENGTH_SHORT).show()
    }

    fun makeToast(res: Int) {
        Toast.makeText(this, getString(res),  Toast.LENGTH_SHORT).show()
    }

    fun makeAlternativeDialog(titleResId: Int, messageResId: Int, negativeResId: Int, positiveResId: Int,
                              negativeListener: DialogInterface.OnClickListener,
                              positiveListener: DialogInterface.OnClickListener) {

        val builder = AlertDialog.Builder(
            this@BaseActivity)
        builder.setTitle(titleResId)
        builder.setMessage(messageResId)
        builder.setNegativeButton(negativeResId, negativeListener)
        builder.setPositiveButton(positiveResId, positiveListener)
        builder.show()

    }

    fun makeDialog(titleResId: Int, messageResId: Int, positiveResId: Int,
                   positiveListener: DialogInterface.OnClickListener) {

        val builder = AlertDialog.Builder(
            this@BaseActivity)
        builder.setTitle(titleResId)
        builder.setMessage(messageResId)
        builder.setPositiveButton(positiveResId, positiveListener)
        builder.show()

    }

    private fun detachComposite() {
        CompositeDisposable().clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        detachComposite()
    }
}
package com.knowre.android.support

import com.google.gson.Gson

internal object GsonProvider {

    private val gson = Gson()

    fun get() = gson

}
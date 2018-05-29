package com.knowre.android

import com.google.gson.Gson

object GsonProvider {

    private val gson = Gson()

    fun get() = gson

}
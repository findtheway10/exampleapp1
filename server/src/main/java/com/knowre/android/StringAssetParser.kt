package com.knowre.android

import android.content.Context
import java.io.IOException

class StringAssetParser(private val context: Context) {

    @Throws(IOException::class)
    fun get(assetName: String): String {
        val json: String

        val inputStream = context.assets.open(assetName)

        val buffer = ByteArray(inputStream.available())

        inputStream.read(buffer)
        inputStream.close()

        json = String(buffer)

        return json
    }

}
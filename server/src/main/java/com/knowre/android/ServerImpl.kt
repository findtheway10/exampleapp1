package com.knowre.android

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.knowre.android.dto.LessonsEnvelope
import com.knowre.android.dto.LoginResponse
import com.knowre.android.dto.Problem
import com.knowre.android.support.GsonProvider
import com.knowre.android.support.StringAssetParser


class ServerImpl(context: Context) : Server {

    private var networkLatencyInMillis = 1000L

    private val parser = StringAssetParser(context)

    private val handler = Handler(Looper.getMainLooper())

    override fun login(id: String, password: String, callback: Server.Callback<LoginResponse>) {
        val jsonString = if (id == "knowre" && password == "1234") {
            parser.get("login_success.json")
        } else {
            parser.get("login_fail.json")
        }

        handler.postDelayed({
            callback.onResponse(GsonProvider.get().fromJson(jsonString, LoginResponse::class.java))
        }, networkLatencyInMillis)
    }

    override fun getLessonsEnvelope(callback: Server.Callback<LessonsEnvelope>) {
        val jsonString = parser.get("lessons_2_completed.json")

        handler.postDelayed({
            callback.onResponse(GsonProvider.get().fromJson(jsonString, LessonsEnvelope::class.java))
        }, networkLatencyInMillis)
    }

    override fun getProblem(lessonNumber: Int, problemNumber: Int, callback: Server.Callback<Problem>) {
        val jsonString = when (problemNumber) {
            1 -> parser.get("problem_1_of_lesson_1.json")
            2 -> parser.get("problem_1_of_lesson_2.json")
            3 -> parser.get("problem_1_of_lesson_3.json")
            else -> throw IllegalArgumentException("problem number cannot be over 3. it was [ $problemNumber ]")
        }

        handler.postDelayed({
            callback.onResponse(GsonProvider.get().fromJson(jsonString, Problem::class.java))
        }, networkLatencyInMillis)
    }

    fun setNetworkLatency(latencyInMillis: Long): ServerImpl {
        networkLatencyInMillis = latencyInMillis

        return this
    }

}
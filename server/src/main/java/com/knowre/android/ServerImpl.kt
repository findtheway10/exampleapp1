package com.knowre.android

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.knowre.android.dto.*
import com.knowre.android.support.JsonConvertableServer


class ServerImpl(context: Context) : JsonConvertableServer(context), Server {

    private val handler = Handler(Looper.getMainLooper())

    override fun login(id: String, password: String, callback: Server.Callback<LoginResponse>) {
        handler.postDelayed({
            callback.onResponse(getLoginResponse(id, password))
        }, networkLatencyInMillis)
    }

    override fun fetchLessonsEnvelope(callback: Server.Callback<LessonsEnvelope>) {
        handler.postDelayed({
            callback.onResponse(getLessonsEnvelope())
        }, networkLatencyInMillis)
    }

    override fun fetchLessonData(lessonType: LessonType, lessonNumber: Int, callback: Server.Callback<LessonData>) {
        handler.postDelayed({
            callback.onResponse(getLessonData(lessonType, lessonNumber))
        }, networkLatencyInMillis)
    }

    override fun fetchProblem(lessonNumber: Int, problemNumber: Int, callback: Server.Callback<Problem>) {
        handler.postDelayed({
            callback.onResponse(getProblem(lessonNumber, problemNumber))
        }, networkLatencyInMillis)
    }

    fun setNetworkLatency(latencyInMillis: Long): ServerImpl {
        networkLatencyInMillis = latencyInMillis

        return this
    }

}
package com.knowre.android

import android.content.Context
import com.knowre.android.dto.LessonsEnvelope
import com.knowre.android.dto.LoginResponse
import com.knowre.android.dto.Problem
import com.knowre.android.support.JsonConvertableServer
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class RxServerImpl(context: Context) : JsonConvertableServer(context), RxServer {

    override fun login(id: String, password: String): Single<LoginResponse> {
        return Single.just(getLoginResponse(id, password)).delay(networkLatencyInMillis, TimeUnit.MILLISECONDS)
    }

    override fun fetchLessonsEnvelope(): Single<LessonsEnvelope> {
        return Single.just(getLessonsEnvelope()).delay(networkLatencyInMillis, TimeUnit.MILLISECONDS)
    }

    override fun fetchProblem(lessonNumber: Int, problemNumber: Int): Single<Problem> {
        return Single.just(getProblem(lessonNumber, problemNumber)).delay(networkLatencyInMillis, TimeUnit.MILLISECONDS)
    }

}
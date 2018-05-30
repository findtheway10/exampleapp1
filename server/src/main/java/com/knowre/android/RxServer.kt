package com.knowre.android

import com.knowre.android.dto.LessonsEnvelope
import com.knowre.android.dto.LoginResponse
import com.knowre.android.dto.Problem
import io.reactivex.Single

interface RxServer {
    fun login(id: String, password: String): Single<LoginResponse>
    fun fetchLessonsEnvelope(): Single<LessonsEnvelope>
    fun fetchProblem(lessonNumber: Int, problemNumber: Int): Single<Problem>
}
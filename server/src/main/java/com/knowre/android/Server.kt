package com.knowre.android

import com.knowre.android.dto.LessonsEnvelope
import com.knowre.android.dto.LoginResponse
import com.knowre.android.dto.Problem


interface Server {
    interface Callback<in T> {
        fun onResponse(response: T)
        fun onFailure(t: Throwable)
    }

    fun login(id: String, password: String, callback: Callback<LoginResponse>)
    fun fetchLessonsEnvelope(callback: Callback<LessonsEnvelope>)
    fun fetchProblem(lessonNumber: Int, problemNumber: Int, callback: Callback<Problem>)
}
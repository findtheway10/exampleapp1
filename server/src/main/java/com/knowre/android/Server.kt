package com.knowre.android

import com.knowre.android.dto.*


interface Server {
    interface Callback<in T> {
        fun onResponse(response: T)
        fun onFailure(t: Throwable)
    }

    fun login(id: String, password: String, callback: Callback<LoginResponse>)
    fun fetchLessonsEnvelope(callback: Callback<LessonsEnvelope>)
    fun fetchLessonData(lessonType: LessonType, lessonNumber: Int, callback: Callback<LessonData>)
    fun fetchProblem(lessonNumber: Int, problemNumber: Int, callback: Callback<Problem>)
}
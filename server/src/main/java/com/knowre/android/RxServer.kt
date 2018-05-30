package com.knowre.android

import com.knowre.android.dto.*
import io.reactivex.Single

interface RxServer {
    fun login(id: String, password: String): Single<LoginResponse>
    fun fetchLessonsEnvelope(): Single<LessonsEnvelope>
    fun fetchLessonData(lessonType: LessonType, lessonNumber: Int): Single<LessonData>
    fun fetchProblem(lessonNumber: Int, problemNumber: Int): Single<Problem>
}
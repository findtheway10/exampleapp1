package com.knowre.android.support

import android.content.Context
import com.knowre.android.dto.LessonsEnvelope
import com.knowre.android.dto.LoginResponse
import com.knowre.android.dto.Problem

open class JsonConvertableServer(context: Context) {

    protected var networkLatencyInMillis = 1000L

    private val parser = StringAssetParser(context)

    fun getLoginResponse(id: String, password: String): LoginResponse {
        val jsonString = if (id == "knowre" && password == "1234") {
            parser.get("login_success.json")
        } else {
            parser.get("login_fail.json")
        }

        return GsonProvider.get().fromJson(jsonString, LoginResponse::class.java)
    }

    fun getLessonsEnvelope(): LessonsEnvelope {
        val jsonString = parser.get("lessons_2_completed.json")

        return GsonProvider.get().fromJson(jsonString, LessonsEnvelope::class.java)
    }

    fun getProblem(lessonNumber: Int, problemNumber: Int): Problem {
        val jsonString = when (problemNumber) {
            1 -> parser.get("problem_1_of_lesson_1.json")
            2 -> parser.get("problem_2_of_lesson_1.json")
            3 -> parser.get("problem_3_of_lesson_1.json")
            else -> throw IllegalArgumentException("problem number cannot be over 3. it was [ $problemNumber ]")
        }

        return GsonProvider.get().fromJson(jsonString, Problem::class.java)
    }

}
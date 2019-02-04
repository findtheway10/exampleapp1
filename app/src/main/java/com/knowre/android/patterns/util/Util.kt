package com.knowre.android.patterns.util

import com.knowre.android.dto.LessonType
import com.knowre.android.patterns.R

fun getLessenTypeText(lessonType: LessonType): Int {

    return when (lessonType) {
        LessonType.Basic -> R.string.lesson_type_basic
        LessonType.Test -> R.string.lesson_type_test
    }

}
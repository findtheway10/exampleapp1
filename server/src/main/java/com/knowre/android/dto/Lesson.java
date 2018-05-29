package com.knowre.android.dto;

public final class Lesson {

    public final Integer lessonNumber;
    public final String lessonName;
    public final boolean isLessonCompleted;

    public Lesson(Integer lessonNumber, String lessonName, boolean isLessonCompleted) {
        this.lessonNumber = lessonNumber;
        this.lessonName = lessonName;
        this.isLessonCompleted = isLessonCompleted;
    }

}

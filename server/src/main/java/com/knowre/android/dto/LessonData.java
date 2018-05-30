package com.knowre.android.dto;


public final class LessonData {

    public final LessonType lessonType;
    public final int lessonNumber;
    public final String lessonName;
    public final int problemCount;

    public LessonData(LessonType lessonType, int lessonNumber, String lessonName, int problemCount) {
        this.lessonType = lessonType;
        this.lessonNumber = lessonNumber;
        this.lessonName = lessonName;
        this.problemCount = problemCount;
    }

}

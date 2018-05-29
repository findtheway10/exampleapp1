package com.knowre.android.dto;

import java.util.List;

public final class LessonsEnvelope {

    public final List<Lesson> lessons;

    public LessonsEnvelope(List<Lesson> lessons) {
        this.lessons = lessons;
    }

}

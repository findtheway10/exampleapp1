package com.knowre.android.dto;

public final class Problem {

    public final String problemContent;
    public final String correctAnswer;

    public Problem(String problemContent, String correctAnswer) {
        this.problemContent = problemContent;
        this.correctAnswer = correctAnswer;
    }

}

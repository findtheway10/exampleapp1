package com.knowre.android.dto;

public final class Problem {

    public final int problemNumber;
    public final String problemContent;
    public final String correctAnswer;

    public Problem(int problemNumber, String problemContent, String correctAnswer) {
        this.problemNumber = problemNumber;
        this.problemContent = problemContent;
        this.correctAnswer = correctAnswer;
    }
}

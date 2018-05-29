package com.knowre.android;

interface Server {
    String login(String id, String password);
    String getLessons();
    String getProblem(int lessonNumber, int problemNumber);
}

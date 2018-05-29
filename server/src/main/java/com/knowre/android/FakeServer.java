package com.knowre.android;

import android.content.Context;
import java.io.IOException;

public final class FakeServer implements Server {
    private final StringAssetParser parser;

    public FakeServer(Context context) {
        parser = new StringAssetParser(context);
    }

    @Override
    public String login(String id, String password) {
        if(id == null || password == null) {
            throw new IllegalArgumentException("id or password cannot be null");
        }

        try {
            if(id.equals("knowre") && password.equals("1234")) {
                return parser.get("login_success.json");
            } else {
                return parser.get("login_fail.json");
            }

        } catch(IOException e) {
            e.printStackTrace();

            throw new RuntimeException("cannot parse the asset json");
        }
    }

    @Override
    public String getLessons() {
        try {
            return parser.get("lessons_2_completed.json");

        } catch(IOException e) {
            e.printStackTrace();

            throw new RuntimeException("cannot parse the asset json");
        }
    }

    @Override
    public String getProblem(int lessonNumber, int problemNumber) {
        try {
            switch(problemNumber) {
                case 1: {
                    return parser.get("problem_1_of_lesson_1.json");
                }
                case 2: {
                    return parser.get("problem_1_of_lesson_2.json");
                }
                case 3: {
                    return parser.get("problem_1_of_lesson_3.json");
                }
                default: {
                    throw new IllegalArgumentException("problem number cannot be over 3. it was [ " + problemNumber + " ]");
                }
            }

        } catch(IOException e) {
            e.printStackTrace();

            throw new RuntimeException("cannot parse the asset json");
        }
    }

}

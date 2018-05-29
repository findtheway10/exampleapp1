package com.knowre.android.patterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LessonSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_selection);

        findViewById(R.id.basic_lesson).setOnClickListener(v -> {
            startActivity(new Intent(this, ProblemSolvingActivity.class));
        });
    }

}

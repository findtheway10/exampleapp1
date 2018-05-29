package com.knowre.android.patterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.knowre.android.Server;
import com.knowre.android.ServerImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Server server = new ServerImpl(this);

        findViewById(R.id.do_login).setOnClickListener(v -> {
            findViewById(R.id.io_progress).setVisibility(View.VISIBLE);

            server.login("knowre", "1234", response -> {
                findViewById(R.id.io_progress).setVisibility(View.GONE);

                if(response.isLoginSuccess) {
                    startActivity(new Intent(this, LessonSelectionActivity.class));
                } else {
                    Toast.makeText(this, "login fail", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

}

package com.knowre.android.patterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.knowre.android.Server;
import com.knowre.android.ServerImpl;
import com.knowre.android.dto.LoginResponse;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Server server = new ServerImpl(this);

        findViewById(R.id.do_login).setOnClickListener(v -> {
            server.login("knowre", "1234", new Server.Callback<LoginResponse>() {
                @Override
                public void onResponse(LoginResponse response) {
                    if(response.isLoginSuccess) {
                        startActivity(new Intent(MainActivity.this, LessonSelectionActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "login fail", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NotNull Throwable t) {

                }
            });
        });
    }

}

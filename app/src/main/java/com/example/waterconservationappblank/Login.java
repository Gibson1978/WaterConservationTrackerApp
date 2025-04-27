package com.example.waterconservationappblank;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;


public class Login extends AppCompatActivity {

    EditText emailField, passwordField;
    Button loginBtn, signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        loginBtn = findViewById(R.id.loginButton);
        signupBtn = findViewById(R.id.signupButton);

        loginBtn.setOnClickListener(v -> attemptLogin());
        signupBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void attemptLogin() {
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        if (!email.isEmpty() && !password.isEmpty()) {
            // Go to main activity which will be dashboard
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);

            // Optional: clear the back stack so user can't go back to login
            finish();
        } else {
            Toast.makeText(Login.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }

    }
}






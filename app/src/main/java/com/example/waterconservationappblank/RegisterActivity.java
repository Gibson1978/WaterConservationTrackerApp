package com.example.waterconservationappblank;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;

public class RegisterActivity extends AppCompatActivity {

    EditText nameField, emailField, passwordField, passwordConfField;

    TextView toLogin;
    Button registerBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameField = findViewById(R.id.et_username);
        emailField = findViewById(R.id.et_email);
        passwordField = findViewById(R.id.et_password);
        passwordConfField = findViewById(R.id.et_confirm_password);
        toLogin = findViewById(R.id.tv_toLogin);
        registerBut = findViewById(R.id.btn_register);

        registerBut.setOnClickListener(v -> attemptRegister());
        toLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, Login.class);
            startActivity(intent);
        });


    }

    private void attemptRegister() {
        String username = nameField.getText().toString().trim();
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();
        String confPassword = passwordConfField.getText().toString().trim();

        if (!email.isEmpty() && !password.isEmpty() && !username.isEmpty() && confPassword.equals(password)) {
            // Go to main activity which will be dashboard
            Intent intent = new Intent(RegisterActivity.this, Login.class);
            startActivity(intent);

            // Optional: clear the back stack so user can't go back to login
            finish();
        } else {
            Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }

    }
}
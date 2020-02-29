package com.example.codenextapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ApplicationActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText firstNameEditText;
    EditText lastNameEditText;
    Button signUpButton;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application);

        emailEditText = findViewById(R.id.emailEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        signUpButton = findViewById(R.id.signUpButton);
        status = findViewById(R.id.status);
    }

    public void goBack(View view) {
        Intent intent = new Intent(ApplicationActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        if(emailEditText.getText().toString().trim().length() > 0) {
            if(firstNameEditText.getText().toString().trim().length() > 0) {
                if(lastNameEditText.getText().toString().trim().length() > 0) {
                    emailEditText.getText().clear();
                    firstNameEditText.getText().clear();
                    lastNameEditText.getText().clear();
                    status.setTextColor(getResources().getColor(R.color.green));
                    status.setText("Sign up successful!");
                }
            }
        }
        else {
            status.setTextColor(getResources().getColor(R.color.red));
            status.setText("Required fields not filled.");
        }
    }
}

package com.example.fyppharmacistregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnLoginConsultant;
    private EditText etName, etPassword;
    private DBHelper dbHelper = new DBHelper(getApplicationContext());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLoginConsultant = findViewById(R.id.btnLoginConsultant);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);

        if (!etName.getText().toString().trim().equals("") && !etPassword.getText().toString().trim().equals("")) {

        }

    }
}
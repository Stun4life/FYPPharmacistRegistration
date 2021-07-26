package com.example.fyppharmacistregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btnLoginConsultant;
    private EditText etName, etPassword;
    private DBHelper dbHelper = new DBHelper(getApplicationContext());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnLoginConsultant = findViewById(R.id.btnLoginConsultant);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);

        if (!etName.getText().toString().trim().equals("") && !etPassword.getText().toString().trim().equals("")) {
            String nameInput = etName.getText().toString();
            String passwordInput = etPassword.getText().toString();

            try {
                DBHelper dbh = new DBHelper(RegisterActivity.this);

                Consultant consultant = new Consultant(nameInput, passwordInput);

                long inserted_id = dbh.insertPatientDetails(consultant);
                Log.i("id for insert", String.valueOf(inserted_id));
                dbh.close();

                if(inserted_id != -1){
                    Toast.makeText(RegisterActivity.this, "Patient details has been successfully added", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                }

            } catch (NumberFormatException e) {
                Toast.makeText(RegisterActivity.this, "Invalid fields. Please try to input the fields again", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
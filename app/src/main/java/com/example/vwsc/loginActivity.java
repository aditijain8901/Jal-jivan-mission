package com.example.vwsc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    private EditText name, phone;
    private ImageView jaljivan , shrushti;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        login = findViewById(R.id.btn_login);
        jaljivan = findViewById(R.id.jaljivanlogo);
        shrushti= findViewById(R.id.shrushtilogo);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginfun();
            }
        });
        jaljivan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(loginActivity.this, aboutActivity.class);
                startActivity(in);
            }
        });
        shrushti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(loginActivity.this, creatorActivity.class);
                startActivity(in);
            }
        });
    }

    void loginfun() {
        if (!validate()) {
            onLoginFailed();
            return;
        }
        login.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(loginActivity.this, R.style.AlertDialogLogin);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("Authenticating...");
        progressDialog.setMessage("Loading");
        progressDialog.show();
        onLoginSuccess();
    }
    public boolean validate() {
        boolean valid = true;
        String nameText = name.getText().toString().trim();
        String phoneText = phone.getText().toString().trim();

        if (nameText.isEmpty()) {
            name.setError("अपना नाम भरें");
            valid = false;
        } else {
            name.setError(null);
        }

        if (phoneText.length() < 10) {
            phone.setError("मान्य फ़ोन नंबर भरें");
            valid = false;
        } else {
            phone.setError(null);
        }

        return valid;
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "लॉगिन विफल", Toast.LENGTH_SHORT).show();
        login.setEnabled(true);
    }
    public void onLoginSuccess() {
        login.setEnabled(true);
        String nameText = name.getText().toString().trim();
        String phoneText = phone.getText().toString().trim();
        Intent i = new Intent(loginActivity.this, dashboardActivity.class);
        Toast.makeText(getBaseContext(), "लॉगिन सफल", Toast.LENGTH_SHORT).show();
        i.putExtra("namepassed",nameText);
        startActivity(i);
        finish();
    }
}
package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
    }

    public void btnLogin(View view) {
        Intent intent = new Intent(this, Third.class);
        startActivity(intent);
        finish();
    }

    public void btnRegistration(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
        finish();
    }
}
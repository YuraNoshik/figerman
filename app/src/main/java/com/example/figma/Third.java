package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);



    }


    public void BackScreen(View view) {
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    public void Login(View view) {
        //Button buttonLogin = findViewById(R.id.buttonLogin);
        EditText editTextMail = findViewById(R.id.editTextMail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        String login = editTextMail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (login.trim().isEmpty() && password.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(),"Введите логин и пароль",Toast.LENGTH_SHORT).show();
        }
        else    {
            if (login.trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Введите логин",Toast.LENGTH_SHORT).show();
            }

            if (password.trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Введите пароль",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
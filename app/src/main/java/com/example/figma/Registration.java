package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class Registration extends AppCompatActivity {

    Button btAdd_reg, btRead_reg, btDelete_reg;
    EditText mail_reg, password_reg,  name_reg, surname_reg;
    BDHelp dbHelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btAdd_reg = findViewById(R.id.btAdd_reg);
        btAdd_reg.setOnClickListener(this::onClick);
        btRead_reg = findViewById(R.id.btRead_reg);
        btRead_reg.setOnClickListener(this::onClick);
        btDelete_reg = findViewById(R.id.btDelete_reg);
        btDelete_reg.setOnClickListener(this::onClick);

        mail_reg = findViewById(R.id.mail_reg);
        password_reg = findViewById(R.id.password_reg);
        name_reg = findViewById(R.id.name_reg);
        surname_reg = findViewById(R.id.surname_reg);

        dbHelp = new BDHelp(this);

    }

    public void btnBackReg(View view) {
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
        finish();
    }

    public void onClick(View view) {

        String name = name_reg.getText().toString();
        String surname = surname_reg.getText().toString();
        String mail = mail_reg.getText().toString();
        String password = password_reg.getText().toString();

        SQLiteDatabase database = dbHelp.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (view.getId()) {

            case R.id.btAdd_reg:
                contentValues.put(dbHelp.KEY_MAIL, mail);
                contentValues.put(dbHelp.KEY_PASSWORD, password);
                contentValues.put(dbHelp.KEY_NAME, name);
                contentValues.put(dbHelp.KEY_SURNAME, surname);


                database.insert(dbHelp.TABLE_CONTACTS, null, contentValues);
                break;

            case R.id.btRead_reg:

                Cursor cursor = database.query(dbHelp.TABLE_CONTACTS, null , "WHERE" + dbHelp.KEY_NAME + " = name", null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(dbHelp.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(dbHelp.KEY_NAME);
                    int surnameIndex = cursor.getColumnIndex(dbHelp.KEY_SURNAME);
                    int mailIndex = cursor.getColumnIndex(dbHelp.KEY_MAIL);
                    int passwordIndex = cursor.getColumnIndex(dbHelp.KEY_PASSWORD);
                    do {
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) + ", name = " + cursor.getString(nameIndex) + ", surname = " + cursor.getString(surnameIndex) + ", mail = " + cursor.getString(mailIndex) + ", password = " + cursor.getString(passwordIndex));
                    }
                    while (cursor.moveToNext());
                } else
                    Log.d("mLog", "0 rows");
                cursor.close();
                break;

            case R.id.btDelete_reg:
                database.delete(dbHelp.TABLE_CONTACTS, null, null);
                break;



        }
    }
}
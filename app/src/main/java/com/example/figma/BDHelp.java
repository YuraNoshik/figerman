package com.example.figma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDHelp extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "reg";
    public static final String TABLE_CONTACTS = "registration";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_SURNAME = "Surname";
    public static final String KEY_MAIL = "mail";
    public static final String KEY_PASSWORD = "password";

    public BDHelp(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONTACTS + "( " + KEY_ID + " INTEGER primary key,"  + KEY_NAME + " text, " + KEY_SURNAME + " text, " + KEY_MAIL + " text, " + KEY_PASSWORD + " text " + ")" );
    }
    public String DropTable = "DROP table Users";
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int n) {
        if(i != n) {
            sqLiteDatabase.execSQL(DropTable);
            onCreate(sqLiteDatabase);
        }
    }
}

package com.example.poketracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PokeTracker.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MY_DATA_TABLE = "CREATE TABLE " + MyDataContract.MyDataEntry.TABLE_NAME + " (" +
                MyDataContract.MyDataEntry.NAME + " TEXT NOT NULL, " +
                MyDataContract.MyDataEntry.NATIONAL_NUMBER + " INTEGER NOT NULL, " +
                MyDataContract.MyDataEntry.SPECIES + " TEXT, " +
                MyDataContract.MyDataEntry.HEIGHT + " FLOAT, " +
                MyDataContract.MyDataEntry.WEIGHT + " FLOAT, " +
                MyDataContract.MyDataEntry.HP + " INTEGER, " +
                MyDataContract.MyDataEntry.ATTACK + " REAL NOT NULL, " +
                MyDataContract.MyDataEntry.DEFENSE + "INTEGER, );";

        db.execSQL(SQL_CREATE_MY_DATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

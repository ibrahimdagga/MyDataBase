package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DB_Name = "cars_db";
    public static final int DB_Virsion = 1;
    public static final String account_TB_Name = "ACCOUNT";
    public static final String account_CLN_ID = "id";
    public static final String account_CLN_NAME = "name";
    public static final String account_CLN_PASSWORD = "password";
    public static final String account_CLN_EMAIL = "email";


    public MyDatabase(@Nullable Context context) {
        super(context, DB_Name, null, DB_Virsion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + account_TB_Name +
                " (" +
                account_CLN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT," +
                account_CLN_NAME + " TEXT," +
                account_CLN_PASSWORD + " INTEGER ," +
                account_CLN_EMAIL + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + account_TB_Name);
        onCreate(db);
    }

    //  إضافة بيانات على الجدول
    public boolean insert(ACCOUNT account) {
        boolean createSuccessful = false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(account_CLN_NAME, account.getName());
        values.put(account_CLN_EMAIL, account.getEmail());
        values.put(account_CLN_PASSWORD, account.getPassword());

        createSuccessful = db.insert(account_TB_Name, null, values)>0;
        db.close();

        return createSuccessful;

    }


    public List<ACCOUNT> getAllNames() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {account_CLN_NAME};
        String sqlTable = account_TB_Name;
        qb.setTables(sqlTable);

        Cursor cursor = qb.query(db, sqlSelect, null,null, null, null, null);


        List<ACCOUNT> accounts = new ArrayList<>();
        if (cursor.moveToNext()) {
            do {
                accounts.add(new ACCOUNT(
                        cursor.getString(cursor.getColumnIndex(account_CLN_NAME))
                ));
            } while (cursor.moveToNext());
        }

        return accounts;
    }



    //     إرجاع عدد صفوف في جدول معين
    public long getAccountNumber() {

        SQLiteDatabase db = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, account_TB_Name);
    }
}

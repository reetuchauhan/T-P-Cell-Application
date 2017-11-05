package com.example.muska.tp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION='1';
    public static final String DATABASE_NAME="contacts.db";
    public static final String TABLE_NAME="contacts";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_USERNAME="username";
    public static final String COLUMN_PASSWORD="password";
    SQLiteDatabase db;
    Cursor cursor;

    public static final String CREATE_TABLE="create table if not exists contacts(name varchar not null,email varchar primary key not null,username varchar not null,password varchar not null)";

    String query="select * from contacts";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db=db;
        cursor=db.rawQuery(query,null);
       // db.close();
    }
    public void insertContact(Contact c)
    {
        db= this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_USERNAME,c.getUname());
        values.put(COLUMN_PASSWORD,c.getPass());
        db.insert(TABLE_NAME,null,values);
        cursor= db.rawQuery(query,null);
       // db.close();
    }

    public String searchPass(String uname) {
        db = this.getReadableDatabase();
        String query = "select username,password from " + TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (c.moveToFirst()) {
            do {

                a = c.getString(0);
                if (a.equals(uname)) {
                    b = c.getString(1);
                    break;
                }
            } while (c.moveToNext());


        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query="DROP TABLE"+TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }


    public List<String> getAllContacts() {
        List<String> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "select username from " + TABLE_NAME;

        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String a,b;

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                a = cursor.getString(0);
                contactList.add(a);
               // contactList.add(b);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

}

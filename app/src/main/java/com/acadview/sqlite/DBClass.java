package com.acadview.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB";
    private static  final int DATABASE_VERSION = 1;

    public DBClass(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USER (Name text, Password text, Number text,Type text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(sqLiteDatabase);

    }

    public  boolean oonAddData(String name,String password, String number,String type){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Password",password);
        contentValues.put("Number",number);
        contentValues.put("Type",type);

        long status = sqLiteDatabase.insert("USER",null,contentValues);

        contentValues.clear();

        return  (status > -1);
    }

    Cursor getdata(){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query("USER",null,null,null,null,null,null);
        return cursor;
    }


//    delete data

    public  void onDelete(String name){
        SQLiteDatabase db = getWritableDatabase();

        String[] arr = null;
        arr[0] = name;

        db.delete("USER","Name = ?",arr);
    }


}

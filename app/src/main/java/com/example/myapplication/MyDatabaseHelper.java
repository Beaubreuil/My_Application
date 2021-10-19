package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Traduction";

    // Table name: Note.
    private static final String TABLE_DICO = "Dictionnaire";
    private static final String COLUMN_MOT_ID ="Mot_id";
    private static final String COLUMN_MOT_LANG1 ="Mot_Lang1";
    private static final String COLUMN_MOT_LANG2 = "Mot_Lang2";
    private static final String COLUMN_MOT_CATE = "Cate";

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script to create table.
        String script = "CREATE TABLE " + TABLE_DICO + "("
                + COLUMN_MOT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_MOT_LANG1 + " TEXT,"
                + COLUMN_MOT_LANG2 + " TEXT," + COLUMN_MOT_CATE + " TEXT" + ")";
        // Execute script.
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DICO);

        // Recreate
        onCreate(db);
    }

    public void addEntry(String lang1, String lang2, String cate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MOT_LANG1, lang1);
        values.put(COLUMN_MOT_LANG2, lang2);
        values.put(COLUMN_MOT_CATE, cate);

        db.insert(TABLE_DICO,null,values);
        db.close();
    }

    public void removeEntry(){

    }

    public Cursor getEntry(String recup,String clause, String option) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectquery = "SELECT " + recup + " FROM " + TABLE_DICO + " " + clause + " " + option + ";";
        //Cursor c = db.rawQuery(selectquery,null);
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_DICO + ";", null);
        //db.close();
        return c;
    }

}

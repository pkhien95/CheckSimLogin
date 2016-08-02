package com.example.hienpk.checksimlogin.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by TungHH on 8/2/2016.
 *
 * Helper class use for create or update database file
 */
public class DataOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = DataOpenHelper.class.getSimpleName();

    // Database's version
    public static final int DATABASE_VERSION = 1;

    // Database file's name
    private static final String FILE_NAME = "sqlite_data.db";

    public DataOpenHelper(Context context){
        super(context, FILE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserInfoEntry.SQL_CREATE_ENTRIES);
        Log.d(TAG, "Created database. File name: " + FILE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldver, int newver) {
        db.execSQL(UserInfoEntry.SQL_DELETE_ENTRIES);
        Log.d(TAG, "Deleted database. File name: " + FILE_NAME);
        onCreate(db);
    }
}

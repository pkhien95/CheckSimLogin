package com.example.hienpk.checksimlogin.model;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.security.Provider;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by TungHH on 8/2/2016.
 */
public class UserInfoProvider extends ContentProvider {

    private static final String TAG = UserInfoProvider.class.getSimpleName();

    public static final String PROVIDER_NAME
            = "com.example.hienpk.checksimlogin.provider.UserInfoProvider";
    public static final String URL
            = "content://" + PROVIDER_NAME + "/UserInfo";
    public static final Uri URI = Uri.parse(URL);

    // init urimatcher for mapping url
    private static final UriMatcher URI_MATCHER
            = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int USERS = 1;
    private static final int USER_ID = 2;
    static {
        URI_MATCHER.addURI(PROVIDER_NAME, "UserInfo", USERS);
        URI_MATCHER.addURI(PROVIDER_NAME, "UserInfo/#", USER_ID);
    }


    // project map contains data filter by column
    public static HashMap<String, String> USERINFO_PROJECTION_MAP
            = new HashMap<>();
    static {
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry._ID, UserInfoEntry._ID);
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry.COLUMN_USER_NAME, UserInfoEntry.COLUMN_USER_NAME);
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry.COLUMN_PASSWORD, UserInfoEntry.COLUMN_PASSWORD);
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry.COLUMN_FULL_NAME, UserInfoEntry.COLUMN_FULL_NAME);
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry.COLUMN_DOB, UserInfoEntry.COLUMN_DOB);
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry.COLUMN_EMAIL, UserInfoEntry.COLUMN_EMAIL);
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry.COLUMN_GEDNER, UserInfoEntry.COLUMN_GEDNER);
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry.COLUMN_MEMBER_CLASS, UserInfoEntry.COLUMN_MEMBER_CLASS);
        USERINFO_PROJECTION_MAP.put(
                UserInfoEntry.COLUMN_OCCUPATION, UserInfoEntry.COLUMN_OCCUPATION);
    }

    private DataOpenHelper mDbHelper;
    private SQLiteDatabase mSQLiteDb;

    @Override
    public boolean onCreate() {
        // open database for write
        mDbHelper = new DataOpenHelper(getContext());
        try {
            mSQLiteDb = mDbHelper.getWritableDatabase();
        }catch (SQLiteException e){
            return false;
        }
        if (mSQLiteDb == null){
            Log.d(TAG, "Open database successed");
            return true;
        }else{
            Log.d(TAG, "Open database failed");
            return false;
        }
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection,
                        String selection, String[] selectionArgs, String order) {

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(UserInfoEntry.TABLE_NAME);
        switch (URI_MATCHER.match(uri)){
            case USERS:
                builder.setProjectionMap(USERINFO_PROJECTION_MAP);
                break;
            case USER_ID:
                builder.appendWhere(UserInfoEntry._ID + " = "
                        + uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("Cannot mapping request");
        }
        if (order == null || order.isEmpty())
            order = UserInfoEntry._ID;
        Cursor rs = builder.query(mSQLiteDb, projection,
                selection, selectionArgs, null,null, order);
        rs.setNotificationUri(getContext().getContentResolver(), uri);
        return rs;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (URI_MATCHER.match(uri)){
            case USERS:
                return "vnd.android.cursor.dir/vnd.example.hienpk.checksimlogin.provider.UserInfoProvider";
            case USER_ID:
                return "vnd.android.cursor.item/vnd.example.hienpk.checksimlogin.provider.UserInfoProvider";
            default:
                throw new IllegalArgumentException("Cannot mapping request");

        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = mSQLiteDb.insert(UserInfoEntry.TABLE_NAME, "",values);
        if (id > 0){
            Uri _uri = ContentUris.withAppendedId(uri,id);
            getContext().getContentResolver().notifyChange(uri,null);
            return _uri;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)  {
        // TODO:
        // sqlitedb.delete ...
        // getContext().getContentResolver().notifyChange(uri, null);

        Log.e(TAG, "delete function has not implemented yet");

        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        Log.e(TAG, "update function has not implemented yet");
        return 0;
    }
}

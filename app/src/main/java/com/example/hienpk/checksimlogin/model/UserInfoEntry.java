package com.example.hienpk.checksimlogin.model;

import android.provider.BaseColumns;

/**
 * Created by TungHH on 8/2/2016.
 *
 * Entry Class contains
 * list of columns name,
 * create table statement,
 * delete table statement
 */
public abstract class UserInfoEntry implements BaseColumns {

    public static final String TABLE_NAME = "USERINFO";

    // List of data columns
    public static final String COLUMN_USER_NAME = "UserName";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_FULL_NAME = "FullName";
    public static final String COLUMN_DOB = "DOB";
    public static final String COLUMN_EMAIL  = "Email";
    public static final String COLUMN_GEDNER = "Gender";
    public static final String COLUMN_MEMBER_CLASS = "MemberClass";
    public static final String COLUMN_OCCUPATION = "Occupation";

    private static final String COMMA_SEP = ",";

    // List of Sqlite data types
    public static final String TEXT_TYPE = "Text";
    public static final String INT_TYPE = "Integer";
    public static final String REAL_TYPE = "Real";

    public static final String SQL_CREATE_ENTRIES =
            "Create table " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_USER_NAME + " " + TEXT_TYPE + COMMA_SEP +
                    COLUMN_PASSWORD + " " + TEXT_TYPE + COMMA_SEP +
                    COLUMN_FULL_NAME + " " + INT_TYPE + COMMA_SEP +
                    COLUMN_DOB  + " " + REAL_TYPE + COMMA_SEP +
                    COLUMN_EMAIL + " " + TEXT_TYPE + COMMA_SEP +
                    COLUMN_GEDNER + " " + TEXT_TYPE + COMMA_SEP +
                    COLUMN_MEMBER_CLASS + " " + TEXT_TYPE + COMMA_SEP +
                    COLUMN_OCCUPATION + " " + TEXT_TYPE + " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

}

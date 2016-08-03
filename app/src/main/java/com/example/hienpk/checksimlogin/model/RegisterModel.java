package com.example.hienpk.checksimlogin.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Debug;
import android.util.Log;
import com.example.hienpk.checksimlogin.presenter.RegisterPresenter;

/**
 * Created by HienPK on 8/3/2016.
 */
public class RegisterModel implements IRegisterModel
{
    private static final String TAG = RegisterModel.class.getSimpleName();

    RegisterPresenter presenter;

    public RegisterModel(RegisterPresenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void addAccount(Context context, UserInfo userInfo)
    {
        // init content values
        ContentValues values = new ContentValues();
        values.put(UserInfoEntry.COLUMN_USER_NAME, userInfo.getUserName());
        values.put(UserInfoEntry.COLUMN_PASSWORD,userInfo.getPassword());
        values.put(UserInfoEntry.COLUMN_FULL_NAME, userInfo.getFullName());
        values.put(UserInfoEntry.COLUMN_DOB, userInfo.getBirthDay());
        values.put(UserInfoEntry.COLUMN_GEDNER, userInfo.getGender());
        values.put(UserInfoEntry.COLUMN_EMAIL, userInfo.getEmail());
        values.put(UserInfoEntry.COLUMN_MEMBER_CLASS, userInfo.getMemberClass());
        values.put(UserInfoEntry.COLUMN_OCCUPATION, userInfo.getOccupation());

        Uri uri = context.getContentResolver().insert(UserInfoProvider.URI, values);
        if (uri == null){
            Log.d(TAG, "insert failed");
        }else {
            Log.d(TAG, "insert successfull");
        }
    }

    @Override
    /**
     * Check if user name is exist
     * @return true if username is exist, false if username is not exist
     */
    public boolean checkUsername(Context context, String username) throws Exception {
        Uri uri = UserInfoProvider.URI;
        Cursor cs = context.getContentResolver().query(
                uri,
                new String[]{UserInfoEntry._ID},
                UserInfoEntry.COLUMN_DOB + "=?",
                new String[]{username},
                null);

        if (cs == null){
            Log.d(TAG, "Query failed");
            throw new Exception("Query failed");
        }else if (cs.getCount() == 0){
            return true;
        }else{
            return false;
        }
    }
}

package com.example.hienpk.checksimlogin.model;

import android.database.Cursor;
import android.net.Uri;

import com.example.hienpk.checksimlogin.presenter.LoginPresenter;

/**
 * Created by HienPK on 8/2/2016.
 */
public class LoginModel implements ILoginModel
{
    LoginPresenter presenter;

    public LoginModel(LoginPresenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public boolean checkUsername(String username)
    {
        Uri uri = Uri.parse(UserInfoProvider.URL);
        String[] projections = new String[UserInfoProvider.USERINFO_PROJECTION_MAP.size()];
        Cursor cs = presenter.getContext().getContentResolver().query(uri,
                UserInfoProvider.USERINFO_PROJECTION_MAP.values().toArray(projections),
                "_id=?",
                new String[]{"" + 1},
                null);
        if (cs.getCount() > 0)   //Username existed
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPassword(String username, String password)
    {
        Uri uri = Uri.parse(UserInfoProvider.URL);
        Cursor cs = presenter.getContext().getContentResolver().query(uri,
                new String[]{UserInfoEntry.COLUMN_PASSWORD},
                "Username=?",
                new String[]{"" + username},
                null);

        if (cs != null && cs.getCount() > 0)
        {
            if (cs.getString(0).equals(password))
            {
                return true;
            }
        }


        return false;
    }
}

package com.example.hienpk.checksimlogin.presenter;

import android.content.Context;

/**
 * Created by HienPK on 8/2/2016.
 */
public interface ILoginPresenter
{
    void checkUsername(String username);

    void checkPassword(String username, String password);

    Context getContext();
}

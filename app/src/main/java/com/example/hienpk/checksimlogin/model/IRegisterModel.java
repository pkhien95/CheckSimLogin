package com.example.hienpk.checksimlogin.model;

import android.content.Context;

/**
 * Created by HienPK on 8/3/2016.
 */
public interface IRegisterModel
{
    void addAccount(Context context, UserInfo userInfo);
    boolean checkUsername(Context context, String username) throws Exception;
}

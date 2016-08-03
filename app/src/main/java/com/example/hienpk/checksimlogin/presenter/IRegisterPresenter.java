package com.example.hienpk.checksimlogin.presenter;

import com.example.hienpk.checksimlogin.model.UserInfo;

/**
 * Created by HienPK on 8/3/2016.
 */
public interface IRegisterPresenter
{
    void checkUsername(String userName);

    void addAccount(UserInfo userInfo);
}

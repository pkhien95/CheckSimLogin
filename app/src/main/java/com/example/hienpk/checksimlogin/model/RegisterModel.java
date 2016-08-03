package com.example.hienpk.checksimlogin.model;

import com.example.hienpk.checksimlogin.presenter.RegisterPresenter;

/**
 * Created by HienPK on 8/3/2016.
 */
public class RegisterModel implements IRegisterModel
{
    RegisterPresenter presenter;

    public RegisterModel(RegisterPresenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void addAccount(UserInfo userInfo)
    {

    }
}

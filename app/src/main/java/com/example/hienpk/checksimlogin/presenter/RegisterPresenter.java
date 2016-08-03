package com.example.hienpk.checksimlogin.presenter;

import com.example.hienpk.checksimlogin.model.RegisterModel;
import com.example.hienpk.checksimlogin.model.UserInfo;
import com.example.hienpk.checksimlogin.view.IRegisterView;

/**
 * Created by HienPK on 8/3/2016.
 */
public class RegisterPresenter implements IRegisterPresenter
{

    IRegisterView view;
    RegisterModel model;

    public RegisterPresenter(IRegisterView view)
    {
        this.view = view;
        model = new RegisterModel(this);
    }

    @Override
    public boolean checkUsername(String userName)
    {
        return false;
    }

    @Override
    public void addAccount(UserInfo userInfo)
    {
        if (!checkUsername(userInfo.getUserName()))
        {
            view.showNote("User name already exists");
            return;
        }

    }
}

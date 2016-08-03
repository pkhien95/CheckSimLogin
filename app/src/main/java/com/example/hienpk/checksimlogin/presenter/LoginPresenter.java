package com.example.hienpk.checksimlogin.presenter;

import android.content.Context;

import com.example.hienpk.checksimlogin.model.ILoginModel;
import com.example.hienpk.checksimlogin.model.LoginModel;
import com.example.hienpk.checksimlogin.view.ILoginView;

/**
 * Created by HienPK on 8/2/2016.
 */
public class LoginPresenter implements ILoginPresenter
{
    ILoginView view;
    ILoginModel model;

    public LoginPresenter(ILoginView view)
    {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public boolean checkUsername(String username)
    {
        boolean flag = model.checkUsername(username);
        if (flag)
            return true;
        view.showMessage("Username is not valid");
        return false;

    }

    @Override
    public void checkPassword(String username, String password)
    {
        if (!model.checkPassword(username, password))
        {
            view.showMessage("Password does not match");
        }
        else
        {
            view.showMessage("Login success");
        }
    }

    @Override
    public Context getContext()
    {
        return (Context) view;
    }
}

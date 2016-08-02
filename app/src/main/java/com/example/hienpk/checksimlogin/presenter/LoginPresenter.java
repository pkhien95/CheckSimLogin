package com.example.hienpk.checksimlogin.presenter;

import com.example.hienpk.checksimlogin.view.ILoginView;

/**
 * Created by HienPK on 8/2/2016.
 */
public class LoginPresenter implements ILoginPresenter
{
    ILoginView view;


    public LoginPresenter(ILoginView view)
    {
        this.view = view;
    }

    @Override
    public void checkUsername()
    {
        view.showMessage("Username is not valid");
    }

    @Override
    public void checkPassword()
    {
        view.showMessage("Password does not match");
    }
}

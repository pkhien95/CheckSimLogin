package com.example.hienpk.checksimlogin.presenter;

import com.example.hienpk.checksimlogin.model.UserInfo;

import java.util.Calendar;

/**
 * Created by HienPK on 8/3/2016.
 */
public interface IRegisterPresenter
{
    boolean checkUsername();

    void addAccount();

    boolean checkRequiredField();

    void setUserName();
    void setPassword();
    void setFullName();
    void setBirthday();
    void setEmail();
    void setGender();
    void setMemberClass();
    void setOccupation();
}

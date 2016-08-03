package com.example.hienpk.checksimlogin.view;

/**
 * Created by HienPK on 8/3/2016.
 */
public interface IRegisterView
{
    void showNote(String note);

    String getUserName();

    String getPassword();

    String getFullName();

    long getBirthday();

    String getEmail();

    String getGender();

    String getMemberClass();

    String getOccupation();

    void registerSuccess();
}

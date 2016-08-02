package com.example.hienpk.checksimlogin.model;

/**
 * Created by HienPK on 8/2/2016.
 */
public interface ILoginModel
{
    boolean checkUsername(String username);

    boolean checkPassword(String username, String password);
}

package com.example.hienpk.checksimlogin.view;

import android.app.Activity;

/**
 * Created by HienPK on 8/2/2016.
 */
public interface ILoginView
{
    Activity getContext();

    void showMessage(String message);
}

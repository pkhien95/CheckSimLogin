package com.example.hienpk.checksimlogin.presenter;

import com.example.hienpk.checksimlogin.view.ICheckView;

/**
 * Created by HienPK on 8/2/2016.
 */
public class Presenter implements IVPresenter, IMPresenter
{

    ICheckView view;

    public Presenter(ICheckView view)
    {
        this.view = view;
    }

    @Override
    public void onShowView()
    {
        view.showButtons();
    }
}

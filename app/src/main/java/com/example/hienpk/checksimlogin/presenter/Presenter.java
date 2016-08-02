package com.example.hienpk.checksimlogin.presenter;

import android.content.Context;
import android.telephony.TelephonyManager;

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
    public void onCheckSim()
    {
        TelephonyManager telMgr = (TelephonyManager) view.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        int simState = telMgr.getSimState();
        switch (simState)
        {
            case TelephonyManager.SIM_STATE_ABSENT:

                break;
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                // do something
                break;
            case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                // do something
                break;
            case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                // do something
                break;
            case TelephonyManager.SIM_STATE_READY:
                view.showButtons();
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                // do something
                break;
        }
    }


}

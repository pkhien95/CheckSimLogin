package com.example.hienpk.checksimlogin.presenter;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import com.example.hienpk.checksimlogin.view.ICheckView;
import com.example.hienpk.checksimlogin.view.LoginActivity;
import com.example.hienpk.checksimlogin.view.RegisterActivity;

/**
 * Created by HienPK on 8/2/2016.
 */
public class CheckPresenter implements ICheckPresenter
{

    ICheckView view;

    public CheckPresenter(ICheckView view)
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
                view.showSimAbsentDialog();
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

    @Override
    public void onStartLoginActivity()
    {
        Intent intent = new Intent(view.getContext(), LoginActivity.class);
        view.getContext().startActivity(intent);

    }

    @Override
    public void onStartRegisterActivity()
    {
        Intent intent = new Intent(view.getContext(), RegisterActivity.class);
        view.getContext().startActivity(intent);
    }
}

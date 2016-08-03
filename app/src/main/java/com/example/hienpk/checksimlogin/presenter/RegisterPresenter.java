package com.example.hienpk.checksimlogin.presenter;

import android.app.Activity;
import android.util.Log;

import com.example.hienpk.checksimlogin.model.IRegisterModel;
import com.example.hienpk.checksimlogin.model.RegisterModel;
import com.example.hienpk.checksimlogin.model.UserInfo;
import com.example.hienpk.checksimlogin.view.IRegisterView;

/**
 * Created by HienPK on 8/3/2016.
 */
public class RegisterPresenter implements IRegisterPresenter
{
    private static final String TAG = RegisterPresenter.class.getSimpleName();

    private IRegisterView iView;
    private IRegisterModel iModel;
    private UserInfo mInfo;

    public RegisterPresenter(IRegisterView view){
        iView = view;
        iModel = new RegisterModel();
        mInfo = new UserInfo();
    }

    @Override
    public boolean checkUsername()
    {
        if (iView instanceof Activity) {
            try {
                boolean flag = iModel.checkUsername(((Activity) iView), mInfo.getUserName());
                if (flag == false)
                    iView.showNote("User name is exist");
                return flag;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        else {
            Log.d(TAG, "iView is not implemted");
            return false;
        }
    }

    @Override
    public void addAccount( )
    {
        if (iView instanceof Activity) {
            iModel.addAccount(((Activity) iView), mInfo);
            iView.registerSuccess();
        }
        else {
            Log.d(TAG, "iView is not implemted");
        }
    }

    @Override
    public boolean checkRequiredField() {
        boolean invalidFlag = false; // = true if any field is emply
        if (invalidFlag == false && mInfo.getFullName().isEmpty())
            invalidFlag = true;
        if (invalidFlag == false && mInfo.getUserName().isEmpty())
            invalidFlag = true;
        if (invalidFlag == false && mInfo.getPassword().isEmpty())
            invalidFlag = true;
        if (invalidFlag == false && mInfo.getFullName().isEmpty())
            invalidFlag = true;
        if (invalidFlag == false && mInfo.getEmail().isEmpty())
            invalidFlag = true;
        if (invalidFlag == true)
            iView.showNote("Please fill all field");
        return !invalidFlag;
    }

    @Override
    public void setUserName() {
        mInfo.setUserName(iView.getUserName());
    }

    @Override
    public void setPassword() {
        mInfo.setPassword(iView.getPassword());
    }

    @Override
    public void setFullName() {
        mInfo.setFullName(iView.getFullName());
    }

    @Override
    public void setBirthday() {
        mInfo.setBirthDay(iView.getBirthday());
    }

    @Override
    public void setEmail() {
        mInfo.setEmail(iView.getEmail());
    }

    @Override
    public void setGender() {
        mInfo.setGender(iView.getGender());
    }

    @Override
    public void setMemberClass() {
        mInfo.setMemberClass(iView.getMemberClass());
    }

    @Override
    public void setOccupation() {
        mInfo.setOccupation(iView.getOccupation());
    }


}

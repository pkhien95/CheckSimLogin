package com.example.hienpk.checksimlogin.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.hienpk.checksimlogin.R;

public class RegisterActivity extends AppCompatActivity implements IRegisterView
{

    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiseter_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle(R.string.register_account_title);


    }

    @Override
    public void showNote(String note)
    {

    }
}

package com.example.hienpk.checksimlogin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hienpk.checksimlogin.R;
import com.example.hienpk.checksimlogin.presenter.*;

public class CheckActivity extends AppCompatActivity implements ICheckView
{
    private IVPresenter presenter;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        presenter = new Presenter(this);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setVisibility(View.INVISIBLE);
        btnRegister.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showButtons()
    {
        btnLogin.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.VISIBLE);
    }
}

package com.example.hienpk.checksimlogin.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hienpk.checksimlogin.R;
import com.example.hienpk.checksimlogin.presenter.IVPresenter;
import com.example.hienpk.checksimlogin.presenter.Presenter;

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

        //Check if SIM is ready
        presenter.onCheckSim();
    }

    @Override
    public void showButtons()
    {
        btnLogin.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.VISIBLE);
    }

    @Override
    public Activity getContext()
    {
        return CheckActivity.this;
    }

    @Override
    public void showSimAbsentDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setMessage("Please make sure your SIM is ready then open this app again");
        builder.setMessage("NO READY SIM DETECTED");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                finish();
            }
        });
    }
}

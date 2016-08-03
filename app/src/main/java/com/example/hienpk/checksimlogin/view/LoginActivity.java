package com.example.hienpk.checksimlogin.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hienpk.checksimlogin.R;
import com.example.hienpk.checksimlogin.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements View.OnFocusChangeListener, ILoginView, View.OnClickListener {
    private Toolbar toolbar;
    private TextView tvNote;
    private EditText txtUsername, txtPassword;
    private Button btnPersonalize;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvNote = (TextView) findViewById(R.id.tvNote);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnPersonalize = (Button) findViewById(R.id.btnPersonalize);

        setSupportActionBar(toolbar);
        txtUsername.setOnFocusChangeListener(this);
        txtPassword.setOnFocusChangeListener(this);
        btnPersonalize.setOnClickListener(this);

        presenter = new LoginPresenter(this);
    }


    @Override
    public void onFocusChange(View view, boolean b) {
//        switch (view.getId())
//        {
//            case R.id.txtUsername:
//                if(b)
//                {
//                    tvNote.setText("");
//                }
//                else
//                {
//                    presenter.checkUsername();
//                }
//                break;
//
//            case R.id.txtPassword:
//                if(b)
//                {
//                    tvNote.setText("");
//                }
//                else
//                {
//                    presenter.checkPassword();
//                }
//                break;
//        }
    }

    @Override
    public Activity getContext() {
        return LoginActivity.this;
    }

    @Override
    public void showMessage(String message) {
        tvNote.setText(message);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPersonalize:

                if (presenter.checkUsername(txtUsername.getText().toString()))
                    presenter.checkPassword(txtUsername.getText().toString(), txtPassword.getText().toString());
                break;
        }
    }
}

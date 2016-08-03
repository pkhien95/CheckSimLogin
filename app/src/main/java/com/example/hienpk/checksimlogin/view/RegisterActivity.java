package com.example.hienpk.checksimlogin.view;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hienpk.checksimlogin.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import com.example.hienpk.checksimlogin.presenter.IRegisterPresenter;
import com.example.hienpk.checksimlogin.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity
        implements IRegisterView, TextWatcher, View.OnClickListener, View.OnFocusChangeListener {
    RegisterPresenter presenter;
    private IRegisterPresenter iRegisterPresenter;

    private ActionBar mActionBar;

    private Spinner mSpinnerGender;
    private Spinner mSpinnerClassMember;
    private Spinner mSpinnerOccupation;
    private EditText mUserName;
    private EditText mPassword;
    private EditText mFullName;
    private EditText mBirthday;
    private EditText mEmail;

    private Calendar calendar;

    private Button mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        initEventListener();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle(R.string.register_account_title);

        // init Spinner gender
        mSpinnerGender = initSpinner(R.id.spinner_gender, R.array.genders,
                R.layout.spinner_layout, R.layout.spinner_item);

        // init Spinner class member
        mSpinnerClassMember = initSpinner(R.id.spinner_class_member, R.array.member_class,
                R.layout.spinner_layout, R.layout.spinner_item);

        // init Spinner occupation
        mSpinnerOccupation = initSpinner(R.id.spinner_occupation, R.array.occupation,
                R.layout.spinner_layout, R.layout.spinner_item);

        // init other views
        mUserName = (EditText)findViewById(R.id.tbUserName);
        mFullName = (EditText)findViewById(R.id.tbFullName);
        mPassword = (EditText)findViewById(R.id.tbPassword);
        mBirthday = (EditText)findViewById(R.id.tbBirthday);
        mEmail = (EditText)findViewById(R.id.tbEmail);
        mRegisterButton = (Button)findViewById(R.id.btnPersonalize);

        iRegisterPresenter = new RegisterPresenter(this);
        mBirthday.setOnFocusChangeListener(this);
        calendar = Calendar.getInstance();
    }

    private void initEventListener() {
        mUserName.addTextChangedListener(this);
        mPassword.addTextChangedListener(this);
        mFullName.addTextChangedListener(this);
        mBirthday.addTextChangedListener(this);
        mEmail.addTextChangedListener(this);

        mSpinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                iRegisterPresenter.setGender();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });
        mSpinnerClassMember.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                iRegisterPresenter.setMemberClass();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });
        mSpinnerOccupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                iRegisterPresenter.setOccupation();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mRegisterButton.setOnClickListener(this);
    }

    private Spinner initSpinner(@IdRes int idRes, @ArrayRes int items,
                                @LayoutRes int layoutSpinner, @LayoutRes int layoutItem) {

        Spinner spinner = (Spinner)findViewById(idRes);
        ArrayAdapter<CharSequence> adapter
                = ArrayAdapter.createFromResource(this, items, layoutSpinner);
        adapter.setDropDownViewResource(layoutItem);
        spinner.setAdapter(adapter);
        return spinner;
    }

    @Override
    public void showNote(String note)
    {
        Toast.makeText(getApplicationContext(), note, Toast.LENGTH_SHORT).show();
    }


    @Override
    public String getUserName() {
        return mUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public String getFullName() {
        return mFullName.getText().toString();
    }

    @Override
    public long getBirthday() {
        return calendar.getTimeInMillis();
    }

    @Override
    public String getEmail() {
        return mEmail.getText().toString();
    }

    @Override
    public String getGender() {
        return (String) mSpinnerGender.getSelectedItem();
    }

    @Override
    public String getMemberClass() {
        return (String) mSpinnerClassMember.getSelectedItem();
    }

    @Override
    public String getOccupation() {
        return (String) mSpinnerOccupation.getSelectedItem();
    }

    @Override
    public void registerSuccess() {
        showNote("Registered");
        this.finish();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        // do nothing
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        // do nothing
    }

    @Override
    public void afterTextChanged(Editable editable) {
        iRegisterPresenter.setBirthday();
        iRegisterPresenter.setEmail();
        iRegisterPresenter.setFullName();
        iRegisterPresenter.setPassword();
        iRegisterPresenter.setUserName();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPersonalize:
                if (iRegisterPresenter.checkRequiredField()
                        && iRegisterPresenter.checkUsername())
                    iRegisterPresenter.addAccount();
                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean focus)
    {
        if (focus)
        {
            DatePickerDialog dlg = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener()
            {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int date)
                {
                    mBirthday.setText((month + 1) + "/" + date + "/" + year);
                    calendar.set(year, month, date);
                    iRegisterPresenter.setBirthday();
                }

            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            dlg.show();
        }
    }
}


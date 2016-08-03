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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hienpk.checksimlogin.R;
import com.example.hienpk.checksimlogin.model.UserInfo;
import com.example.hienpk.checksimlogin.presenter.RegisterPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity implements IRegisterView, View.OnClickListener, AdapterView.OnItemSelectedListener, View.OnFocusChangeListener
{
    RegisterPresenter presenter;
    private ActionBar mActionBar;
    private Spinner mSpinnerGender;
    private Spinner mSpinnerClassMember;
    private Spinner mSpinnerOccupation;
    private Button btnPersonalize;
    private EditText txtUserName, txtPassword, txtFullName, txtDateOfBirth, txtEmail;
    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new RegisterPresenter(this);

        btnPersonalize = (Button) findViewById(R.id.btnPersonalize);
        txtUserName = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtFullName = (EditText) findViewById(R.id.txtFullName);
        txtDateOfBirth = (EditText) findViewById(R.id.txtDateOfBirth);
        txtEmail = (EditText) findViewById(R.id.txtEmail);

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

        btnPersonalize.setOnClickListener(this);
        mSpinnerGender.setOnItemSelectedListener(this);
        mSpinnerClassMember.setOnItemSelectedListener(this);
        mSpinnerOccupation.setOnItemSelectedListener(this);
        txtDateOfBirth.setOnFocusChangeListener(this);
        calendar = Calendar.getInstance();
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
        Toast.makeText(getApplicationContext(), note, Toast.LENGTH_SHORT);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnPersonalize:
                UserInfo userInfo = new UserInfo();
                userInfo.setUserName(txtUserName.getText().toString());
                userInfo.setPassword(txtPassword.getText().toString());
                userInfo.setFullName(txtFullName.getText().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yy", Locale.ENGLISH);
                try
                {
                    calendar.setTime(sdf.parse(txtDateOfBirth.getText().toString()));
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                userInfo.setBirthDay(calendar);
                userInfo.setEmail(txtEmail.getText().toString());
                userInfo.setGender(mSpinnerGender.getSelectedItem().toString());
                userInfo.setMemberClass(mSpinnerClassMember.getSelectedItem().toString());
                userInfo.setOccupation(mSpinnerOccupation.getSelectedItem().toString());
                presenter.addAccount(userInfo);
                break;

//            case R.id.txtDateOfBirth:
//
//                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
//        switch (view.getId())
//        {
//            case R.id.spinner_gender:
//                break;
//
//            case R.id.spinner_class_member:
//                break;
//
//            case R.id.spinner_occupation:
//                break;
//        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

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
//                    calendar.set(year, month, date);
                    txtDateOfBirth.setText((month + 1) + "/" + date + "/" + year);
                }

            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            dlg.show();
        }
    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
//    {
//
//    }
}

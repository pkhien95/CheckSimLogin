package com.example.hienpk.checksimlogin.view;

import android.support.annotation.ArrayRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hienpk.checksimlogin.R;

public class RegiseterAccountActivity extends AppCompatActivity {

    private ActionBar mActionBar;
    private Spinner mSpinnerGender;
    private Spinner mSpinnerClassMember;
    private Spinner mSpinnerOccupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiseter_account);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tool_bar);
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
}

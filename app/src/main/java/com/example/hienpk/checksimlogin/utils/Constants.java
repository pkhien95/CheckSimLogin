package com.example.hienpk.checksimlogin.utils;

import android.content.Context;
import android.net.Uri;

import com.example.hienpk.checksimlogin.model.UserInfoProvider;

/**
 * Created by TungHH on 8/2/2016.
 */
public class Constants {

    public static final String[] GENDERS = {
            "Female",
            "Male"
    };

    public static final String[] MEMBER_CLASSES = {
            "Standard",
            "Pro",
            "VIP"
    };

    public static final String[] OCCUPATIONS = {
            "Student",
            "Teacher",
            "Actor",
            "Coder",
            "Artist"
    };


    private void __(Context context, int id){
        Uri uri = Uri.parse(UserInfoProvider.URL);
        context.getContentResolver().query(uri,
                (String[]) UserInfoProvider.USERINFO_PROJECTION_MAP.values().toArray(),
                "id=?",
                new String[]{"" + id},
                null);
    }
}

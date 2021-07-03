package com.example.leafrecognition;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private SharedPreferences mySharedPref;

    public SharedPref(Context context) {
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }


    public void setBaseUrl(String baseUrl) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putString("baseUrl", baseUrl);
        editor.apply();
    }

    public void setLoginStep(String LoginStep) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putString("LoginStep", LoginStep);
        editor.apply();
    }

    public String getBaseUrl() {
        return "http://" + mySharedPref.getString("baseUrl", "");
    }

    public String getLoginStep() {
        return mySharedPref.getString("LoginStep", LoginStep.welcome.toString());
    }


}

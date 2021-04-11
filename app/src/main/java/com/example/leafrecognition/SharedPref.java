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

    public String  getBaseUrl() {
        return "http://"+mySharedPref.getString("baseUrl", "95.179.164.66:5000");
    }
}

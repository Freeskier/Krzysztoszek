package com.client.LocalStorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.client.Models.User;
import com.google.gson.Gson;


public class Storage {
    static final String STORAGE_USER= "user";
    static final String STORAGE_TOKEN= "token";


    public static void setUser(User user, Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(STORAGE_USER, new Gson().toJson(user));
        editor.putString(STORAGE_TOKEN, user.getToken());
        editor.apply();
    }

    public static User getUser(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if(prefs.getString(STORAGE_USER, "").equals(""))
            return null;
        return new Gson().fromJson(prefs.getString(STORAGE_USER, ""), User.class);
    }

    public static String getToken(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(STORAGE_TOKEN, "");
    }

    public static void removeUser(Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.clear();
        editor.apply();
    }
}

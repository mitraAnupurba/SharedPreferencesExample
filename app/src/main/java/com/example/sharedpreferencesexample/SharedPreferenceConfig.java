package com.example.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;

//class that handles the  shared preferences:
//here we create an object of the shared preferences class, not the shared preferences config class
public class SharedPreferenceConfig {

    private SharedPreferences sharedPreferences ;
    private Context context;

    //in the constructor, we initialise 2 variables: context and shared preferences
    public SharedPreferenceConfig(Context context){
        this.context = context;

        //accessing the shared preferences file through our shared preferences object:
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE);


    }
    public void writeLoginStatus(boolean status)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference),status);
        editor.commit();
    }

    public boolean readLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference),false);
        return status;
    }

}

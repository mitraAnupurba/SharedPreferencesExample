package com.example.sharedpreferencesexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


//ID of editText's in the main activity: user_name - enter user name,
//ID of editText's in the main activity: user_password - enter the user password.

//variable name to get the view's from main activity.xml - userName, userPassword
public class MainActivity extends AppCompatActivity {

    private SharedPreferenceConfig sharedPreferenceConfig;
    private EditText userName, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        userName = findViewById(R.id.user_name);
        userPassword = findViewById(R.id.user_password);

        //checking whether user login or not:
        if(sharedPreferenceConfig.readLoginStatus()){
            startActivity(new Intent(this,SuccessActivity.class));
            //
            finish();
        }

    }

    public void loginUser(View view) {

        Toast.makeText(this,"Login failed, try again",Toast.LENGTH_SHORT);

        String username = userName.getText().toString();
        String userpassword = userPassword.getText().toString();




        if(username.equals(getResources().getString(R.string.user_name_actual)) && userpassword.equals(getResources().getString(R.string.user_password_actual))){
            startActivity(new Intent(this,SuccessActivity.class));

            //sharing the success of login status to the sharedPreferences class:
            sharedPreferenceConfig.writeLoginStatus(true);
            finish();
        }
        else{
            Toast.makeText(this,"Login failed, try again",Toast.LENGTH_SHORT);
            userName.setText(" ");
            userPassword.setText(" ");
        }


    }
}

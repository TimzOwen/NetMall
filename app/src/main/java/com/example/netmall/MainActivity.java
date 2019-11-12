package com.example.netmall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declare the buttons here
    private Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call the function to collect Ids
        collectIds();

        //set the onClick listener for logining in
        btnLogin.setOnClickListener(this);

    }

    //create a method to collect the ids form the Views on the xml
    public void collectIds()
    {
        btnLogin = findViewById(R.id.btn_main_login);
        btnSignUp = findViewById(R.id.btn_main_join);
    }

    @Override
    public void onClick(View view)
    {
        //check for the Button that has been selected
        if(view==btnLogin)
        {
            //move from This launcher activity to Login Activity
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        }
        if (view==btnSignUp)
        {
            //move from launcher activity to sign up activity
            Intent signUpIntent =  new Intent(this,SignUpActivity.class);
            startActivity(signUpIntent);
        }

    }

}

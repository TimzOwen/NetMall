package com.example.netmall;

import androidx.appcompat.app.AppCompatActivity;

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

        }
        if (view==btnSignUp)
        {

        }

    }

}

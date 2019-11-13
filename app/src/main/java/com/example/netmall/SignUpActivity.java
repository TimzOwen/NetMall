package com.example.netmall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth=FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

    }

    public void fetchIds()
    {
        btnSignUp = findViewById(R.id.btn_join);
    }

    @Override
    public void onClick(View v)
    {
        if (v==btnSignUp)
        {
            signUpProgress();
        }
    }

    private void signUpProgress()
    {

    }
}

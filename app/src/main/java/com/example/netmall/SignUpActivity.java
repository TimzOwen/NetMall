package com.example.netmall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;
    private Button btnSignUp;
    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth=FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

        fetchIds();

    }

    public void fetchIds()
    {
        btnSignUp = findViewById(R.id.btn_join);
        etEmail = findViewById(R.id.et_input_email_number);
        etPassword = findViewById(R.id.et_input_password_number);

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

        mDialog.setTitle("Registering....");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();

        //collect String for email and passwprd
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                   if (task.isSuccessful())
                   {
                       //sign up the user
                       mDialog.dismiss();
                   }
                    }
                })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //show the user if the registration fails
                mDialog.dismiss();
            }
        });

    }
}

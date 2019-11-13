package com.example.netmall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etMail, etPassWord;
    private Button btnLogin;
    private TextView tvForgotPass, tvIamAdmin;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

        colecctIds();


    }
    public void colecctIds()
    {
        etMail = findViewById(R.id.et_input_email_number);
        etPassWord=findViewById(R.id.et_input_password_number);
        btnLogin=findViewById(R.id.btn_loginpg_join);
        tvForgotPass= findViewById(R.id.tv_forgotPassword);
        tvIamAdmin=findViewById(R.id.tv_admin);
    }

    @Override
    public void onClick(View v)
    {
        if (v==btnLogin)
        {
                validateUser();
        }
        if (v==tvForgotPass)
        {

        }
        if (v==tvIamAdmin)
        {

        }
    }

    private void validateUser()
    {
        mDialog.setTitle("Welcome To NetMall");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();

        String email = etMail.getText().toString().trim();
        String password = etPassWord.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            //login
                            mDialog.dismiss();
                        }
                        else
                        {
                            //setErrorMessage
                            mDialog.dismiss();
                        }
                    }
                });
    }
}

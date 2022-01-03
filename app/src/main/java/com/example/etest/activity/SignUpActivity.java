package com.example.etest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.etest.R;
import com.example.etest.main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {


    private EditText etemail, etpassword;
    private TextView tvlogin, tvforgotpassword, tvsignup;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etemail = findViewById(R.id.etEmail);
        etpassword = findViewById(R.id.etPassword);
        tvlogin = findViewById(R.id.tvLogin);
        tvforgotpassword = findViewById(R.id.tvForgotPassword);
        tvsignup = findViewById(R.id.tvSignUp);

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }


        });
        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup() {
        String email, pass;
        email = etemail.getText().toString();
        pass = etpassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui lòng nhập email", Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_LONG).show();
        }

        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Tạo tài khoản thành công",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Tạo tài khoản không thành công vui lòng nhập lại",Toast.LENGTH_LONG).show();
                }
            }
        });
        Intent intent=new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
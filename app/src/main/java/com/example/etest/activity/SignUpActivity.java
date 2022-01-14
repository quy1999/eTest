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


    private EditText atemail, atpassword;
    private TextView tvlogin, tvforgotpassword, tvsignupa;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        atemail = findViewById(R.id.suEmail);
        atpassword = findViewById(R.id.suPassword);
        tvsignupa = findViewById(R.id.tvSignUpA);
        auth=FirebaseAuth.getInstance();

        tvsignupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup() {
        String semail, spass;
        semail = atemail.getText().toString();
        spass = atpassword.getText().toString();


        if (TextUtils.isEmpty(semail) && TextUtils.isEmpty(spass)) {
            Toast.makeText(this, "Vui lòng nhập email hoặc mật khẩu", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(semail) ) {
            Toast.makeText(this, "Vui lòng nhập email", Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(spass)) {
            Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_LONG).show();
        }


        if(semail  != "") {
            auth.createUserWithEmailAndPassword(semail, spass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Bạn đã tạo tài khoản thành công", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Tạo tài khoản không thành công vui lòng nhập lại", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "Nhập thông tin đăng nhập", Toast.LENGTH_LONG).show();
        }
    }

    public void onclickLogin(View view){
        Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);

    }


}
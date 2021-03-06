package com.example.etest.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
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

public class LoginActivity extends AppCompatActivity {

    private EditText etemail, etpassword;
    private TextView tvlogin, tvforgotpassword, tvsignUp;
    private ImageView ivillustration;
    private CheckBox checkBox;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        auth = FirebaseAuth.getInstance();

        etemail = findViewById(R.id.etEmail);
        etpassword = findViewById(R.id.etPassword);
        tvlogin = findViewById(R.id.tvLogin);
        tvforgotpassword = findViewById(R.id.tvForgotPassword);
        tvsignUp = findViewById(R.id.tvSignUp);
        ivillustration = findViewById(R.id.ivIllustration);
        checkBox = findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences settings = getSharedPreferences("PREFS_NAME", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("isChecked", isChecked);
                editor.commit();
            }
        });

        SharedPreferences settings1 = getSharedPreferences("PREFS_NAME", 0);
        boolean isChecked = settings1.getBoolean("isChecked", false);

        if (isChecked) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        tvsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }

            private void signup() {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        tvforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickForGotPassword();
            }
        });
    }

    private void onClickForGotPassword() {
        auth = FirebaseAuth.getInstance();
        String emailAddress = etemail.getText().toString();
        String email;
        email=etemail.getText().toString();

        if ( TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui l??ng nh???p email ????? ?????i m???t kh???u", Toast.LENGTH_LONG).show();
            return;
        }
        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Vui l??ng truy c???p email ????? x??c minh ?????i m???t kh???u", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "?????i m???t kh???u l???i", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }


    private void login() {
        String email, pass;
        email = etemail.getText().toString();
        pass = etpassword.getText().toString();


        if (TextUtils.isEmpty(pass) && TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui l??ng nh???p email ho???c m???t kh???u", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui l??ng nh???p email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui l??ng nh???p m???t kh???u", Toast.LENGTH_LONG).show();
            return;
        }



        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "????ng nh???p th??nh c??ng", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "????ng nh???p kh??ng th??nh c??ng,Vui l??ng nh???p l???i", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onclickSignUp(View view){
        Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);

    }
}
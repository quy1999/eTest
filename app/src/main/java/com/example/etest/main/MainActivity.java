package com.example.etest.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.etest.NavigationActivity;
import com.example.etest.R;
import com.example.etest.activity.ExamActivity;
import com.example.etest.activity.GrammarActivity;
import com.example.etest.activity.LoginActivity;
import com.example.etest.activity.SettingActivity;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ImageView imageView;
    TextView logout;
    String TAD = "quy";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);

        Intent in = getIntent();
        String string = in.getStringExtra("message");
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Đăng xuất!").
                        setMessage("Bạn có chắc chắn muốn đăng xuất không?");
                builder.setPositiveButton("Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                SharedPreferences settings = getSharedPreferences("PREFS_NAME", 0);
                                SharedPreferences.Editor editor = settings.edit();
                                editor.putBoolean("isChecked", false);
                                editor.commit();
                                Intent i = new Intent(getApplicationContext(),
                                        LoginActivity.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //lưu activity mới ,xóa hết activity cũ
                                startActivity(i);
                            }
                        });
                builder.setNegativeButton("Không",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });
    }

    public void onclickPlay(View view) {
        Intent intent = new Intent(MainActivity.this, GrammarActivity.class);
        startActivity(intent);


    }

    public void onclickPlaykiemtra(View view) {
        Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
        startActivity(intent);


    }

    public void onclickPlaybt(View view) {
        Intent intent = new Intent(MainActivity.this, ExamActivity.class);
        startActivity(intent);

    }
    public void onclickPlaysetting(View view) {
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAD, "onCreat");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAD, "onCreat");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAD, "onCreat");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAD, "onCreat");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAD, "onCreat");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAD, "onCreat");
    }


}
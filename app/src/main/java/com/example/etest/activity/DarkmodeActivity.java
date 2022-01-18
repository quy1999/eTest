package com.example.etest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.etest.R;

public class DarkmodeActivity extends AppCompatActivity {

    private Switch aSwitch;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkThemeNight);
        } else {
            setTheme(R.style.AppThemeDay);
        }
        setContentView(R.layout.activity_darkmode);
        aSwitch = findViewById(R.id.mode);
        textView = findViewById(R.id.t1);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {

            aSwitch.setChecked(true);
        }
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    textView.setText("Dark Mode");
                    reset();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    textView.setText("Light Mode");
                    reset();
                }
            }
        });
    }

    public void reset() {

        Intent intent = new Intent(getApplicationContext(), DarkmodeActivity.class);
        startActivity(intent);

    }
}
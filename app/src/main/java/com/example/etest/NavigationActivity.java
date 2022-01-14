package com.example.etest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.etest.Dethi.ExamFour;
import com.example.etest.Dethi.ExamOne;
import com.example.etest.Dethi.ExamThree;
import com.example.etest.Dethi.ExamTwo;
import com.example.etest.Dethi.HomeFragment;
import com.example.etest.question.DPHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

public class NavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.home) {
                    HomeFragment examOne=new HomeFragment();
                    FragmentManager manager=getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment,examOne,examOne.getTag()).commit();
                } else if (id == R.id.De1) {
                    ExamOne examone=new ExamOne();
                    FragmentManager manager=getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment,examone,examone.getTag()).commit();

                } else if (id == R.id.De2) {
                    ExamTwo examtwo=new ExamTwo();
                    FragmentManager manager=getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment,examtwo,examtwo.getTag()).commit();

                } else if (id == R.id.De3){
                    ExamThree examthree= new ExamThree();
                    FragmentManager manager=getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment,examthree,examthree.getTag()).commit();

                } else if (id == R.id.De4){
                    ExamFour examfour= new ExamFour();
                    FragmentManager manager=getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment,examfour,examfour.getTag()).commit();


                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        DPHelper dpHelper=new DPHelper(this);
        try {
            dpHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }







}

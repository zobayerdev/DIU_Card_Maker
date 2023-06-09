package com.juthi.diucardmaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    /*import all package*/
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);


        // #######################
        // Drawer Layout implement
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // #################################################################
        // navigation view work process
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        loadHomeFragment();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.bottom_menu_home) {
                    loadHomeFragment();
                } else if (itemId == R.id.bottom_menu_about) {
                    loadAboutFragment();
                } else if (itemId == R.id.bottom_menu_teacher) {
                    loadTeacherFragment();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Click", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    private void loadHomeFragment() {
        setTitle("Dashboard");
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, homeFragment, "homeFragment");
        fragmentTransaction.commit();
    }

    private void loadTeacherFragment() {
        setTitle("Teacher Activity");
        TeacherFragment teacherFragment = new TeacherFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, teacherFragment, "teacherFragment");
        fragmentTransaction.commit();
    }

    private void loadAboutFragment() {
        setTitle("About our University");
        AboutFragment aboutFragment = new AboutFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, aboutFragment, "aboutFragment");
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.nav_add_teacher:
                // startActivity(new Intent(MainActivity.this, AdminActivity.class));
                Toast.makeText(this, "Add Teacher Details", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AddTeacherActivity.class));
                break;

            case R.id.nav_teacher:
                // startActivity(new Intent(MainActivity.this, AdminActivity.class));
                Toast.makeText(this, "Make a student ID card", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MakeTeacherActivity.class));
                break;

            case R.id.nav_student:
                Toast.makeText(this, "Contact list", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
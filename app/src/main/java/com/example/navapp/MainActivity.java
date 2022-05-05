package com.example.navapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navView;
    private FragmentTransaction ft;
    private ActionBarDrawerToggle at;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        navView = findViewById(R.id.navView);
        at=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(at);
        at.syncState();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new HomeFragment());
                    ft.commit();

                }
                if (id == R.id.nav_profile) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new ProfileFragment());
                    ft.commit();
                }
                if (id == R.id.nav_settings) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new SettingsFragment());
                    ft.commit();
                }
                drawerLayout.closeDrawers();
                return false;
            }

        });
        // drawerLayout.closeDrawers();
    }
}

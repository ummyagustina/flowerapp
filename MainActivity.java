package com.example.flowerapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flowerapp.fragment.FavoriteFragment;
import com.example.flowerapp.fragment.HomeFragment;
import com.example.flowerapp.fragment.ProfielFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar toolbar;
    private AnimatedBottomBar animatedBottomBar;
    private FragmentManager fragmentManager;
    private Toolbar supportActionBar;
    private androidx.appcompat.widget.Toolbar Toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        initViews(savedInstanceState);
        initNavComponent();
    }

    private void initNavComponent() {
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_weed:
                        Toast.makeText(MainActivity.this,"weed",Toast.LENGTH_SHORT).show();
                    case R.id.nav_insects:
                        Toast.makeText(MainActivity.this,"insects",Toast.LENGTH_SHORT).show();
                    case R.id.nav_disease:
                        Toast.makeText(MainActivity.this,"disease",Toast.LENGTH_SHORT).show();
                    case R.id.nav_products:
                        Toast.makeText(MainActivity.this,"products",Toast.LENGTH_SHORT).show();
                    case R.id.nav_help:
                        Toast.makeText(MainActivity.this,"help",Toast.LENGTH_SHORT).show();
                }
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @SuppressLint("NonConstantRecourceId")
    private void initViews(Bundle savedInstanceState) {

        animatedBottomBar = findViewById(R.id.animatedBottomBar);

        if(savedInstanceState==null){
            animatedBottomBar.selectTabById(R.id.home,true);
            fragmentManager = getSupportFragmentManager();

            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer,homeFragment).commit();


        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lasttab,
                                      int newIndex, @NonNull AnimatedBottomBar.Tab newtab) {
                Fragment fragment = null;
                switch (newtab.getId()) {

                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.favorite:
                        fragment = new FavoriteFragment();
                    case R.id.Profile:
                        fragment = new ProfielFragment();
                        break;
                }

                if (fragment !=null){
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
            }
            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawer, Toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(view -> drawer.openDrawer(GravityCompat.START));
        toggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
        toggle.syncState();
    }

    private void setToolbar(){
        Toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( Toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(0);
}

@SuppressLint("SuspiciousIndentation")
@Override
    public void onBackPressed(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
           drawer.closeDrawer(GravityCompat.END);
        }else
        super.onBackPressed();
}

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}

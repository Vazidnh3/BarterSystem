package com.vazidsapplication.barterwave1;

import static android.provider.Telephony.TextBasedSmsColumns.SUBJECT;

import static org.xmlpull.v1.XmlPullParser.TEXT;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.vazidsapplication.barterwave1.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;

    ActivityMainBinding binding;


    TextView reg_btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        bottomNavigationView = findViewById(R.id.btn_view);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
                    loadFragment(new fragment_bottom_home());
                }
                if (id == R.id.search) {
                    loadFragment(new fragment_bottom_search());
                }
                if (id == R.id.add) {
                    loadFragment(new fragment_bottom_add());
                }
                if (id == R.id.chat) {
                    loadFragment(new fragment_bottom_chat());
                }
                if (id == R.id.account) {
                    loadFragment(new fragment_bottom_account());
                }
                return true;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    loadFragment(new fragment_home());
                }
                if (id == R.id.nav_share) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType( "text/ plain" );
                intent.putExtra(Intent.EXTRA_SUBJECT,"Check out this cool Application");
                intent.putExtra(Intent.EXTRA_TEXT,"Your Application Link Here");
                startActivity (Intent.createChooser(intent,"Share Via"));

                }
                if (id == R.id.nav_settings) {
                    loadFragment(new fragment_settings());
                }
                if (id == R.id.nav_about) {
                    loadFragment(new fragment_about());
                }
                if (id == R.id.nav_logout) {
//                    loadFragment(new fragment_settings());
                    final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Logout");
                    alert.setMessage("Are you sure you wish to logout?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent i2 = new Intent(MainActivity.this, MainActivity.class);
                                    i2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(i2);
                                }
                            });
                    alert.show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container,fragment);

        ft.commit();
    }


}
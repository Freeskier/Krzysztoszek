package com.client.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.client.Fragments.AddRoomFragment;
import com.client.LocalStorage.Storage;
import com.client.Models.User;
import com.client.R;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView nameTV, emailTV, typeTV;
    private AddRoomFragment addRoomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        connectViews();
    }

    private void connectViews() {
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(navListener);
        drawerLayout = findViewById(R.id.drawerLayout);
        nameTV = navigationView.getHeaderView(0).findViewById(R.id.nav_nameTitleTV);
        emailTV = navigationView.getHeaderView(0).findViewById(R.id.nav_emailTitleTV);
        typeTV = navigationView.getHeaderView(0).findViewById(R.id.nav_typeTitleTV);
        User loggedUser = Storage.getUser(this);
        if(loggedUser == null) return;
        if(loggedUser.getLogin() != null || loggedUser.getEmail() != null || loggedUser.getType() != null) {
            nameTV.setText(loggedUser.getLogin());
            emailTV.setText(loggedUser.getEmail());
            typeTV.setText(loggedUser.getType());
        }
        MenuItem item =navigationView.getMenu().findItem(R.id.addRoom);
        if(loggedUser.getType().equals("MANAGER")){
            item.setVisible(true);
        }
        else{
            item.setVisible(false);
        }
    }


    private NavigationView.OnNavigationItemSelectedListener navListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.profile:
                            Intent intent2 = new Intent(getApplicationContext(), EditProfileActivity.class);
                            startActivity(intent2);
                            break;
                        case R.id.rooms:
                            Intent intent = new Intent(getApplicationContext(), RoomActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.myReservations:
                            Intent intent3 = new Intent(getApplicationContext(), MyReservationActivity.class);
                            startActivity(intent3);
                            break;
                        case R.id.addRoom:
                            addRoomFragment = new AddRoomFragment();
                            addRoomFragment.show(getSupportFragmentManager(), "addRoom");
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;
                        default:
                            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent1);
                    }
                    return false;
                }
            };

    public void menuClick(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void logOutButtonClick(View view) {
        Storage.removeUser(this);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
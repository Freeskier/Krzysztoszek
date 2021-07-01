package com.client.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.client.Contracts.LoginContract;
import com.client.Interactors.LoginInteractor;
import com.client.LocalStorage.Storage;
import com.client.Models.User;
import com.client.Presenters.LoginActivityPresenter;
import com.client.R;


public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {
    private EditText loginET, passwordET;
    private LoginActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        checkForAutoUpdate();
        connectViews();
    }

    private void checkForAutoUpdate() {
        if(Storage.getUser(this) != null) {
            Toast.makeText(this, "Auto logged in!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void connectViews() {
        loginET = findViewById(R.id.loginET);
        passwordET = findViewById(R.id.paswordET);
        presenter = new LoginActivityPresenter(this, new LoginInteractor());
    }


    public void registerClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void loginClick(View view) {
        User user = new User(loginET.getText().toString(), passwordET.getText().toString());
        presenter.onLoginButtonClick(user);
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
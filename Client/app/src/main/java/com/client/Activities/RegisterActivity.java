package com.client.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.client.Contracts.RegisterContract;
import com.client.Interactors.RegisterInteractor;
import com.client.Models.User;
import com.client.Presenters.RegisterActivityPresenter;
import com.client.R;


public class RegisterActivity extends AppCompatActivity implements RegisterContract.RegisterView {
    private RegisterActivityPresenter presenter;
    private EditText loginET, emailET, passwordET, passwordConfirmET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        connectViews();
    }

    private void connectViews() {
        presenter = new RegisterActivityPresenter(this, new RegisterInteractor());
        loginET = findViewById(R.id.loginET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.paswordET);
        passwordConfirmET = findViewById(R.id.confirmPasswordET);
    }

    public void registerClick(View view) {
        if(!passwordET.getText().toString().equals(passwordConfirmET.getText().toString())){
            Toast.makeText(this, "Given password does not match!", Toast.LENGTH_LONG).show();
            return;
        }
        User user = new User(loginET.getText().toString(), passwordET.getText().toString(), emailET.getText().toString());
        presenter.onRegisterButtonClick(user);
    }


    @Override
    public void onRegisterSuccess() {
        Toast.makeText(this, "Successfully registered!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
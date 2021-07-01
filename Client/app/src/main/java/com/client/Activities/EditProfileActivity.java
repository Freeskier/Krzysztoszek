package com.client.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.client.Contracts.EditProfileContract;
import com.client.Interactors.EditProfileInteractor;
import com.client.Models.User;
import com.client.Presenters.EditProfileActivityPresenter;
import com.client.R;

public class EditProfileActivity extends AppCompatActivity implements EditProfileContract.EditProfileView {
    private EditText loginET, passwordET, emailET, firstNameET, lastNameET;
    private EditProfileActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        connectViews();
    }

    private void connectViews() {
        loginET = findViewById(R.id.loginET);
        passwordET = findViewById(R.id.paswordET);
        emailET = findViewById(R.id.emailET);
        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        presenter = new EditProfileActivityPresenter(this, new EditProfileInteractor());
    }

    public void editClick(View view) {
        if(passwordET.getText().toString().equals(""))
        {
            Toast.makeText(this, "You need to type password!", Toast.LENGTH_LONG).show();
            return;
        }
        presenter.onUpdateButtonClick(new User(loginET.getText().toString(), passwordET.getText().toString(), emailET.getText().toString(),
                firstNameET.getText().toString(), lastNameET.getText().toString()));
    }

    @Override
    public void onUpdateProfileCallback() {
        Toast.makeText(this, "Success! Please re-log.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}
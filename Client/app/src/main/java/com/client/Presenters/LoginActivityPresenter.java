package com.client.Presenters;

import android.widget.Toast;

import com.android.volley.VolleyError;
import com.client.Activities.LoginActivity;
import com.client.Contracts.LoginContract;
import com.client.Interactors.LoginInteractor;
import com.client.LocalStorage.Storage;
import com.client.Models.User;


public class LoginActivityPresenter implements LoginContract.LoginPresenter {
    private LoginActivity activity;
    private LoginInteractor interactor;

    public LoginActivityPresenter(LoginActivity activity, LoginInteractor interactor)
    {
        this.activity = activity;
        this.interactor = interactor;
    }

    @Override
    public void onLoginButtonClick(User user) {
        interactor.loginCall(user, activity, new LoginContract.LoginInteractor.OnLoginListener() {
            @Override
            public void onResponse(User userResponse) {
                Storage.setUser(userResponse, activity);
                activity.onLoginSuccess();
                Toast.makeText(activity, "Login successful.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(activity, "There was a problem with login", Toast.LENGTH_LONG).show();
            }
        });
    }
}

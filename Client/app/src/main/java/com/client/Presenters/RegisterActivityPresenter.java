package com.client.Presenters;

import android.widget.Toast;

import com.android.volley.VolleyError;
import com.client.Activities.RegisterActivity;
import com.client.Contracts.RegisterContract;
import com.client.Interactors.RegisterInteractor;
import com.client.Models.User;


public class RegisterActivityPresenter implements RegisterContract.RegisterPresenter {
    private RegisterActivity activity;
    private RegisterInteractor interactor;

    public RegisterActivityPresenter(RegisterActivity activity, RegisterInteractor interactor) {
        this.activity = activity;
        this.interactor = interactor;
    }

    @Override
    public void onRegisterButtonClick(User user) {
        interactor.registerCall(user, activity, new RegisterContract.RegisterInteractor.OnRegisterListener() {
            @Override
            public void onResponse(User userResponse) {
                activity.onRegisterSuccess();
            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(activity, "Problem with registration.", Toast.LENGTH_LONG).show();
            }
        });
    }
}

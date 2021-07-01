package com.client.Contracts;

import android.content.Context;

import com.android.volley.VolleyError;
import com.client.Models.User;


public interface LoginContract {
    interface LoginPresenter {
        void onLoginButtonClick(User user);
    }

    interface LoginView
    {
        void onLoginSuccess();
    }

    interface LoginInteractor {
        interface OnLoginListener {
            void onResponse(User userResponse);
            void onError(VolleyError error);
        }

        void loginCall(User user, Context context, OnLoginListener onLoginListener);
    }
}

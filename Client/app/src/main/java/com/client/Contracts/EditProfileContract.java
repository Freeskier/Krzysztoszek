package com.client.Contracts;

import android.content.Context;

import com.android.volley.VolleyError;
import com.client.Models.User;

public interface EditProfileContract {
    interface EditProfilePresenter {
        void onUpdateButtonClick(User user);
    }

    interface EditProfileView
    {
        void onUpdateProfileCallback();
    }

    interface EditProfileInteractor {
        interface OnEditProfileListener {
            void onResponse(User userResponse);
            void onError(VolleyError error);
        }

        void updateProfile(User user, Context context, OnEditProfileListener onLoginListener);
    }
}

package com.client.Presenters;

import android.content.Context;

import com.android.volley.VolleyError;
import com.client.Activities.EditProfileActivity;
import com.client.Contracts.EditProfileContract;
import com.client.Interactors.EditProfileInteractor;
import com.client.LocalStorage.Storage;
import com.client.Models.User;

public class EditProfileActivityPresenter implements EditProfileContract.EditProfilePresenter {
    private EditProfileActivity activity;
    private EditProfileInteractor interactor;

    public EditProfileActivityPresenter(EditProfileActivity activity, EditProfileInteractor interactor) {
        this.activity = activity;
        this.interactor = interactor;
    }


    @Override
    public void onUpdateButtonClick(User user) {
        User local = Storage.getUser(activity);
        if(!user.getLogin().equals("") && user.getLogin() != null)
            local.setLogin(user.getLogin());
        if(!user.getPassword().equals("") && user.getLogin() != null)
            local.setPassword(user.getPassword());
        if(!user.getEmail().equals("") && user.getLogin() != null)
            local.setEmail(user.getEmail());
        if(!user.getFirstName().equals("") && user.getLogin() != null)
            local.setFirstName(user.getFirstName());
        if(!user.getLastName().equals("") && user.getLogin() != null)
            local.setLastName(user.getLastName());

        interactor.updateProfile(local, activity, new EditProfileContract.EditProfileInteractor.OnEditProfileListener() {
            @Override
            public void onResponse(User userResponse) {
                Storage.removeUser(activity);
                activity.onUpdateProfileCallback();
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}

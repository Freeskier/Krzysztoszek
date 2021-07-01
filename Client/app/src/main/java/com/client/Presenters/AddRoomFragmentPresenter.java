package com.client.Presenters;

import android.widget.Toast;

import com.android.volley.VolleyError;
import com.client.Contracts.AddRoomContract;
import com.client.Fragments.AddRoomFragment;
import com.client.Interactors.AddRoomFragmentInteractor;
import com.client.Models.Room;
import com.client.Models.User;

public class AddRoomFragmentPresenter implements AddRoomContract.AddRoomFragmentPresenter {
    private AddRoomFragment fragment;
    private AddRoomFragmentInteractor interactor;

    public AddRoomFragmentPresenter(AddRoomFragment fragment, AddRoomFragmentInteractor interactor) {
        this.fragment = fragment;
        this.interactor = interactor;
    }

    @Override
    public void addRoom(Room room) {
        interactor.addRoom(room, fragment.getContext(), new AddRoomContract.AddRoomFragmentInteractor.OnAddListener() {
            @Override
            public void onResponse(User userResponse) {
                fragment.addRoomCallback();
            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(fragment.getContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.client.Presenters;

import com.android.volley.VolleyError;
import com.client.Activities.RoomActivity;
import com.client.Contracts.RoomContract;
import com.client.Interactors.RoomInteractor;
import com.client.Models.Room;

import java.util.List;

public class RoomActivityPresenter implements RoomContract.RoomPresenter {
    private RoomActivity activity;
    private RoomInteractor interactor;

    public RoomActivityPresenter(RoomActivity activity, RoomInteractor interactor) {
        this.activity = activity;
        this.interactor = interactor;
    }

    @Override
    public void getAllRooms() {
        interactor.getAllRooms(activity, new RoomContract.RoomInteractor.OnGetAllRoomsListener() {
            @Override
            public void onResponse(List<Room> rooms) {
                activity.getAllRoomsCallback(rooms);
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}

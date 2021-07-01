package com.client.Presenters;

import android.content.Context;

import com.android.volley.VolleyError;
import com.client.Activities.MyReservationActivity;
import com.client.Contracts.MyReservationContract;
import com.client.Interactors.MyReservationInteractor;
import com.client.Models.Room;

import java.util.List;

public class MyReservationActivityPresenter implements MyReservationContract.MyReservationPresenter {

    private MyReservationActivity activity;
    private MyReservationInteractor interactor;

    public MyReservationActivityPresenter(MyReservationActivity activity, MyReservationInteractor interactor) {

        this.activity = activity;
        this.interactor = interactor;
    }
    @Override
    public void getMyReservation() {
        interactor.getMyReservation(activity, new MyReservationContract.MyReservationInteractor.OnGetMyReservationListener() {
            @Override
            public void onResponse(List<Room> rooms) {
                activity.getMyReservationCallback(rooms);
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}

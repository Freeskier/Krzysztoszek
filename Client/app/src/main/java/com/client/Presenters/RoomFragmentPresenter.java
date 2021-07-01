package com.client.Presenters;

import com.android.volley.VolleyError;
import com.client.Contracts.RoomContract;
import com.client.Contracts.RoomFragmentContract;
import com.client.DTOs.ReservationToRecieve;
import com.client.Fragments.RoomFragment;
import com.client.Interactors.RoomFragmentInteractor;
import com.client.Models.Reservation;
import com.client.Models.Room;
import com.client.Models.User;

public class RoomFragmentPresenter implements RoomFragmentContract.RoomFragmentPresenter  {
    private RoomFragment fragment;
    private RoomFragmentInteractor interactor;

    public RoomFragmentPresenter(RoomFragment fragment, RoomFragmentInteractor interactor) {
        this.fragment = fragment;
        this.interactor = interactor;
    }

    @Override
    public void addReservation(ReservationToRecieve reservation) {
        interactor.addReservation(reservation, fragment.getActivity(), new RoomFragmentContract.RoomFragmentInteractor.OnAddListener() {
            @Override
            public void onResponse(Reservation reservationResponse) {
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}

package com.client.Contracts;

import android.content.Context;

import com.android.volley.VolleyError;
import com.client.DTOs.ReservationToRecieve;
import com.client.Models.Reservation;
import com.client.Models.Room;
import com.client.Models.User;

public interface RoomFragmentContract {
    interface RoomFragmentView{
    }

    interface RoomFragmentPresenter{
        void addReservation(ReservationToRecieve reservation);
    }

    interface RoomFragmentInteractor{
        interface OnAddListener {
            void onResponse(Reservation reservationResponse);
            void onError(VolleyError error);
        }
        void addReservation(ReservationToRecieve reservation, Context context, OnAddListener listener);
    }
}

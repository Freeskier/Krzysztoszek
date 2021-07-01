package com.client.Contracts;

import android.content.Context;

import com.android.volley.VolleyError;
import com.client.Models.Room;

import java.util.List;

public interface MyReservationContract {
    interface MyReservationView{
        void getMyReservationCallback(List<Room> rooms);
    }

    interface MyReservationPresenter{
        void getMyReservation();
    }

    interface MyReservationInteractor{
        interface OnGetMyReservationListener{
            void onResponse(List<Room> rooms);
            void onError(VolleyError error);
        }

        void getMyReservation(Context context, OnGetMyReservationListener listener);
    }
}

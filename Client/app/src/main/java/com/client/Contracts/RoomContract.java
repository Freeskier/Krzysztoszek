package com.client.Contracts;

import android.content.Context;

import com.android.volley.VolleyError;
import com.client.Models.Room;

import java.util.List;

public interface RoomContract {
    interface RoomView{
        void getAllRoomsCallback(List<Room> rooms);
    }

    interface RoomPresenter{
        void getAllRooms();
    }

    interface RoomInteractor{
        interface OnGetAllRoomsListener{
            void onResponse(List<Room> rooms);
            void onError(VolleyError error);
        }

        void getAllRooms(Context context, OnGetAllRoomsListener listener);
    }
}

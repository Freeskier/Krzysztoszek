package com.client.Contracts;

import android.content.Context;

import com.android.volley.VolleyError;
import com.client.Models.Room;
import com.client.Models.User;

public interface AddRoomContract {
    interface AddRoomFragmentView{
        void addRoomCallback();
    }

    interface AddRoomFragmentPresenter{
        void addRoom(Room room);
    }

    interface AddRoomFragmentInteractor{
        interface OnAddListener {
            void onResponse(User userResponse);
            void onError(VolleyError error);
        }
        void addRoom(Room room, Context context, OnAddListener listener);
    }
}

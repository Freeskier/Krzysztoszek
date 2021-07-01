package com.client.Interactors;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.client.Contracts.RoomContract;
import com.client.LocalStorage.Storage;
import com.client.Models.Room;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomInteractor implements RoomContract.RoomInteractor {
    @Override
    public void getAllRooms(Context context, OnGetAllRoomsListener listener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, ConnectionConstans.API_URL + "room/getAll",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TypeToken<List<Room>> token = new TypeToken<List<Room>>(){};
                        List<Room> rooms = new Gson().fromJson(response, token.getType());
                        listener.onResponse(rooms);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error);
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + Storage.getToken(context));
                return headers;
            }
        };
        requestQueue.add(stringRequest);
    }
}

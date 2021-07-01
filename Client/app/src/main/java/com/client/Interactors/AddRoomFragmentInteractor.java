package com.client.Interactors;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.client.Contracts.AddRoomContract;
import com.client.LocalStorage.Storage;
import com.client.Models.Room;
import com.client.Models.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddRoomFragmentInteractor implements AddRoomContract.AddRoomFragmentInteractor {
    @Override
    public void addRoom(Room room, Context context, OnAddListener listener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(new Gson().toJson(room));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, ConnectionConstans.API_URL + "room/add", jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        User u = new Gson().fromJson(response.toString(), User.class);
                        listener.onResponse(u);
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
        requestQueue.add(jsonObjectRequest);
    }
}

package com.client.Interactors;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.client.Contracts.RegisterContract;
import com.client.Models.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterInteractor implements RegisterContract.RegisterInteractor {
    @Override
    public void registerCall(User user, Context context, OnRegisterListener onRegisterListener) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(new Gson().toJson(user));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, ConnectionConstans.API_URL + "user/register", jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        User u = new Gson().fromJson(response.toString(), User.class);
                        onRegisterListener.onResponse(u);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        onRegisterListener.onError(error);
                    }
                });
        requestQueue.add(jsonObjectRequest);

    }
}

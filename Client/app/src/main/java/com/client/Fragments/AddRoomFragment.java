package com.client.Fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.client.Contracts.AddRoomContract;
import com.client.Interactors.AddRoomFragmentInteractor;
import com.client.Models.Room;
import com.client.Presenters.AddRoomFragmentPresenter;
import com.client.R;


public class AddRoomFragment extends DialogFragment implements AddRoomContract.AddRoomFragmentView {

    private AddRoomFragmentPresenter presenter;
    private TextView capacityTV, doorNumTV, imageURLTV, priceTV;
    private Button addBtn;
    public AddRoomFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_add_room, container, false);
        connectViews(view);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().setCanceledOnTouchOutside(true);
        return view;
    }

    private void connectViews(View view) {
        capacityTV = view.findViewById(R.id.capacityAdd);
        doorNumTV = view.findViewById(R.id.doorNumAdd);
        imageURLTV = view.findViewById(R.id.imageAdd);
        priceTV = view.findViewById(R.id.priceAdd);
        addBtn = view.findViewById(R.id.addRoomBtn);
        addBtn.setOnClickListener(btnListener);
        presenter = new AddRoomFragmentPresenter(this, new AddRoomFragmentInteractor());
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Room room = new Room(Integer.parseInt(capacityTV.getText().toString()), Integer.parseInt(doorNumTV.getText().toString()),
                    imageURLTV.getText().toString(), Float.parseFloat(priceTV.getText().toString()));
            presenter.addRoom(room);
        }
    };

    @Override
    public void addRoomCallback() {
        //this.dismiss();
    }
}
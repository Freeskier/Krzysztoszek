package com.client.Fragments;;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.fragment.app.DialogFragment;

import com.client.Contracts.RoomFragmentContract;
import com.client.DTOs.ReservationToRecieve;
import com.client.Interactors.RoomFragmentInteractor;
import com.client.LocalStorage.Storage;
import com.client.Models.Reservation;
import com.client.Models.Room;
import com.client.Presenters.RoomFragmentPresenter;
import com.client.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RoomFragment extends DialogFragment implements RoomFragmentContract.RoomFragmentView {

    private Room room;
    private EditText calendarFrom, calendarTo;
    private EditText actualView;
    private Button addReservationBtn;
    private Calendar calFrom = Calendar.getInstance(), calTo = Calendar.getInstance();
    private RoomFragmentPresenter presenter;
    private NumberPicker numberPicker;

    public RoomFragment(Room room)
    {
        this.room = room;
    }

    DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            if(actualView.getId() == calendarFrom.getId()){
                calFrom.set(Calendar.YEAR, year);
                calFrom.set(Calendar.MONTH, month);
                calFrom.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                actualView.setText(getStringDate(calFrom));
            }
            else {
                calTo.set(Calendar.YEAR, year);
                calTo.set(Calendar.MONTH, month);
                calTo.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                actualView.setText(getStringDate(calTo));
            }
        }
    };

    private String getStringDate(Calendar calendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        return sdf.format(calendar.getTime());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_room, container, false);
        connectViews(view);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().setCanceledOnTouchOutside(true);
        return view;
    }


    private void connectViews(View view)
    {
        presenter = new RoomFragmentPresenter(this, new RoomFragmentInteractor());
        calendarFrom = view.findViewById(R.id.calendarFrom);
        calendarTo = view.findViewById(R.id.calendarTo);
        numberPicker = view.findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(room.getCapacity());
        addReservationBtn = view.findViewById(R.id.addBikeBtn);
        addReservationBtn.setOnClickListener(onButtonClickListener);
        calendarFrom.setOnClickListener(calendarListener);
        calendarTo.setOnClickListener(calendarListener);
    }

    View.OnClickListener onButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.addReservation(new ReservationToRecieve(Storage.getUser(getContext()).getId(), numberPicker.getValue(), room.getId(), calendarFrom.getText().toString(), calendarTo.getText().toString()));
        }
    };

    View.OnClickListener calendarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            actualView = (EditText) v;
            new DatePickerDialog(v.getContext(), dateListener, calFrom.get(Calendar.YEAR),
                    calFrom.get(Calendar.MONTH), calFrom.get(Calendar.DAY_OF_MONTH)).show();

        }
    };
}
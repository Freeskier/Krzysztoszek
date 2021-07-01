package com.client.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.client.Adapters.RoomAdapter;
import com.client.Contracts.MyReservationContract;
import com.client.Fragments.RoomFragment;
import com.client.Interactors.MyReservationInteractor;
import com.client.Models.Room;
import com.client.Presenters.MyReservationActivityPresenter;
import com.client.R;

import java.util.List;

public class MyReservationActivity extends AppCompatActivity implements MyReservationContract.MyReservationView {

    private MyReservationActivityPresenter presenter;
    private RecyclerView recyclerView;
    private RoomAdapter adapter;
    private RoomFragment roomFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_room);
        connectViews();
    }

    private void connectViews() {

        recyclerView = findViewById(R.id.bike_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RoomAdapter(new RoomAdapter.OnClickListener() {
            @Override
            public void onItemClick(Room room) {
                roomFragment = new RoomFragment(room);
                roomFragment.show(getSupportFragmentManager(), "roomFragment");
            }
        });
        recyclerView.setAdapter(adapter);
        presenter = new MyReservationActivityPresenter(this, new MyReservationInteractor());
        presenter.getMyReservation();
    }


    @Override
    public void getMyReservationCallback(List<Room> rooms) {
        adapter.UpdateData(rooms);
        adapter.notifyDataSetChanged();
    }
}
package com.client.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.client.Adapters.RoomAdapter;
import com.client.Contracts.RoomContract;
import com.client.Fragments.RoomFragment;
import com.client.Interactors.RoomInteractor;
import com.client.Models.Room;
import com.client.Presenters.RoomActivityPresenter;
import com.client.R;

import java.util.List;

public class RoomActivity extends AppCompatActivity implements RoomContract.RoomView {

    private RoomActivityPresenter presenter;
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
        presenter = new RoomActivityPresenter(this, new RoomInteractor());
        presenter.getAllRooms();
    }


    @Override
    public void getAllRoomsCallback(List<Room> rooms) {
        adapter.UpdateData(rooms);
        adapter.notifyDataSetChanged();
    }
}
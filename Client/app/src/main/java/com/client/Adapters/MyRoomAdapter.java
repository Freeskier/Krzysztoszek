package com.client.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.client.Models.Room;
import com.client.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyRoomAdapter extends RecyclerView.Adapter {

    public interface OnClickListener{
        void onItemClick(Room room);
    }

    List<Room> rooms;
    OnClickListener listener;
    Context context;
    public MyRoomAdapter(OnClickListener listener) {
        this.listener = listener;
    }

    public void UpdateData(List<Room> list)
    {
        this.rooms = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room_cv, parent, false);
        context = parent.getContext();
        return new RoomAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RoomAdapterViewHolder hld = (RoomAdapterViewHolder) holder;
        hld.nameTV.setText(Integer.toString(rooms.get(position).getDoorNum()));
        hld.priceTV.setText("Price: " + rooms.get(position).getPricePerDay() + "€");
        hld.descriptionTV.setText("Capacity: " + rooms.get(position).getCapacity());
        if(rooms.get(position).getImageURL() != null && !rooms.get(position).getImageURL().equals(""))
            Picasso.with(context).load(rooms.get(position).getImageURL()).into(hld.image);
        hld.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(rooms.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return rooms ==null? 0: rooms.size();
    }
}

class MyRoomAdapterViewHolder extends RecyclerView.ViewHolder
{
    TextView nameTV, priceTV, descriptionTV;
    ImageView image;
    Button button;

    public MyRoomAdapterViewHolder(View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.room_nameCV);
        priceTV = itemView.findViewById(R.id.room_priceCV);
        descriptionTV = itemView.findViewById(R.id.room_descriptionCV);
        image = itemView.findViewById(R.id.bike_imageCV);
        button = itemView.findViewById(R.id.room_bookBTN);
    }

}


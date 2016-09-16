package org.piratejester.technex17.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.piratejester.technex17.R;
import org.piratejester.technex17.adapters.EventsAdapter;
import org.piratejester.technex17.adapters.RecyclerItemClickListener;

import java.util.ArrayList;

public class Events extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<eventlist> events;

    class eventlist {
        String name;

        Bitmap[] bitmaps;
        Bitmap imageicon;


        eventlist(String name, Bitmap[] bitmaps, Bitmap imageicon) {
            this.bitmaps = bitmaps;
            this.name = name;
            this.imageicon = imageicon;
        }

        public Bitmap[] getImage() {
            return bitmaps;
        }

        public String getName() {
            return name;
        }

        public Bitmap getIcon() {
            return imageicon;
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_1);

        String[] names = {"Robotics", "AeroModelling", "SAE", "Astronomy"};
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.robo);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.sae);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.aero);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.robo);
        Bitmap background[] = {bitmap1, bitmap2, bitmap3, bitmap4};

        Bitmap icon1 = BitmapFactory.decodeResource(getResources(), R.drawable.cart_outline);
        Bitmap icons[] = {icon1, icon1, icon1, icon1};

        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EventsAdapter(names, icons, background);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(Events.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("Clicked", "" + position);
                        Intent intent = new Intent(Events.this,EventDetail.class);
                        intent.putExtra("POSITION",position);
                        startActivity(intent);
                    }
                })
        );


    }
}

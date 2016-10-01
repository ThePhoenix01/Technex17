package org.piratejester.technex17.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.piratejester.technex17.R;
import org.piratejester.technex17.adapters.WorkshopAdapter;

public class GuestLecture extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView=(RecyclerView)findViewById(R.id.my_recycler_view_workshop);

        String[] names = {"Ms. Vinita Bali", "Prabhu Chawla", "Santosh Desai", "Prahlad Kakkar"};
        Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), R.drawable.robo);
        Bitmap bitmap2= BitmapFactory.decodeResource(getResources(), R.drawable.sae);
        Bitmap bitmap3= BitmapFactory.decodeResource(getResources(), R.drawable.aero);
        Bitmap bitmap4= BitmapFactory.decodeResource(getResources(), R.drawable.robo);
        Bitmap background[]={bitmap1,bitmap2,bitmap3,bitmap4};

        Bitmap icon1= BitmapFactory.decodeResource(getResources(), R.drawable.cart_outline);
        Bitmap icons[]={icon1,icon1,icon1,icon1};

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new WorkshopAdapter(names,background,icons);
//        Toast.makeText(EventsScreen.this,""+events_mat.size(),Toast.LENGTH_SHORT).show();
        // Log.d("error",""+events_mat.get(3).getImage());

        mRecyclerView.setAdapter(mAdapter);

    }

}

package org.piratejester.technex17.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.piratejester.technex17.R;
import org.piratejester.technex17.activities.EventDetail;
import org.piratejester.technex17.adapters.EventsAdapter;
import org.piratejester.technex17.adapters.RecyclerItemClickListener;

/**
 * Created by root on 18/9/16.
 */
public class EventFragment extends Fragment {
    public EventFragment() {
    }



    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);

        RecyclerView mEventRecycler;
        RecyclerView.Adapter mEventAdapter;
        RecyclerView.LayoutManager mEventLayoutManager;

        String[] names = {"Robotics", "AeroModelling", "SAE", "Astronomy"};
        Bitmap background[] = {
                BitmapFactory.decodeResource(getResources(), R.drawable.sae),
                BitmapFactory.decodeResource(getResources(), R.drawable.aero),
                BitmapFactory.decodeResource(getResources(), R.drawable.robo),
                BitmapFactory.decodeResource(getResources(), R.drawable.sae)
        };

        Bitmap icon1 = BitmapFactory.decodeResource(getResources(), R.drawable.cart_outline);
        Bitmap icons[] = {icon1, icon1, icon1, icon1};

        mEventRecycler = (RecyclerView) rootView.findViewById(R.id.my_recycler_view_1);
        mEventLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mEventRecycler.setLayoutManager(mEventLayoutManager);
        mEventAdapter = new EventsAdapter(names, icons, background);
        mEventRecycler.setAdapter(mEventAdapter);
        mEventRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("Clicked", "" + position);
                        Intent intent = new Intent(getActivity(),EventDetail.class);
                        intent.putExtra("POSITION",position);
                        startActivity(intent);
                    }
                })
        );
        return rootView;
    }
}

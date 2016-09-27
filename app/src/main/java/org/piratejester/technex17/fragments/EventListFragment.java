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
import org.piratejester.technex17.adapters.EventCategoryAdapter;
import org.piratejester.technex17.adapters.RecyclerItemClickListener;

/**
 * Created by root on 18/9/16.
 */
public class EventListFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public EventListFragment() {
    }

    public static EventListFragment newInstance(int sectionNumber) {
        EventListFragment fragment = new EventListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);

        RecyclerView mEventRecycler;
        RecyclerView.Adapter mEventCategoryAdapter;
        RecyclerView.LayoutManager mEventLayoutManager;

        String[] names = {"Robowars", "Hydracs", "Pixelate", "Robohunt"};
        String[] desc = {
                "Have you ever had a fantasy of racing your own hand made bot in a racing competition consisting of numerous thrilling hurdles? Well, it",
                "Have you ever had a fantasy of racing your own hand made bot in a racing competition consisting of numerous thrilling hurdles? Well, it",
                "Have you ever had a fantasy of racing your own hand made bot in a racing competition consisting of numerous thrilling hurdles? Well, it",
                "Have you ever had a fantasy of racing your own hand made bot in a racing competition consisting of numerous thrilling hurdles? Well, it"
        };
        String[] time = {"20th Sept", "10th May", "31st Jan", "20th Dec"};
        int[] team = {3,5,4,5};
        int[] prize = {20000,10000,40000,10000};
        Bitmap bg[] = {
                BitmapFactory.decodeResource(getResources(), R.drawable.sae),
                BitmapFactory.decodeResource(getResources(), R.drawable.aero),
                BitmapFactory.decodeResource(getResources(), R.drawable.robo),
                BitmapFactory.decodeResource(getResources(), R.drawable.sae)
        };


        mEventRecycler = (RecyclerView) rootView.findViewById(R.id.my_recycler_view_1);
        mEventLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mEventRecycler.setLayoutManager(mEventLayoutManager);
        mEventCategoryAdapter = new EventCategoryAdapter(names, desc, team, prize, time, bg);
        mEventRecycler.setAdapter(mEventCategoryAdapter);
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

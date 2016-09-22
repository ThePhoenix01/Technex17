package org.piratejester.technex17.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.piratejester.technex17.R;

/**
 * Created by root on 18/9/16.
 */
public class NewsFragment extends Fragment {
    public NewsFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        /*final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (56 * scale + 0.5f);
        AppBarLayout appBarLayout = (AppBarLayout)getActivity().findViewById(R.id.app_bar);
        appBarLayout.getLayoutParams().height = pixels;
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.getLayoutParams().height = 0;*/
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);

        return rootView;
    }
}

package org.piratejester.technex17.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.piratejester.technex17.R;

/**
 * Created by root on 18/9/16.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    View rootView;
    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    int[] mResources = {R.drawable.carousel2,
            R.drawable.carousel1,
            R.drawable.carousel3
    };

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rootView = view;

        /*final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (160 * scale + 0.5f);
        int pixelt = (int) (56 * scale + 0.5f);
        AppBarLayout appBarLayout = (AppBarLayout)getActivity().findViewById(R.id.app_bar);
        appBarLayout.getLayoutParams().height = pixels;
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.getLayoutParams().height = pixelt;*/


        setupNotifRecyclerView();

        setupNavigRecyclerView();

        return rootView;
    }

    private void setupNotifRecyclerView() {

        mCustomPagerAdapter = new CustomPagerAdapter(getActivity());

        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
        mViewPager.setTop(1);
        mViewPager.bringToFront();


    }

    private void setupNavigRecyclerView() {
        FrameLayout cv1;
        CardView cv2,cv3,cv4,cv5,cv6,cv7,cv8,cv9;
        cv1=(FrameLayout)rootView.findViewById(R.id.cv1);
        cv2=(CardView)rootView.findViewById(R.id.cv2);
        cv3=(CardView)rootView.findViewById(R.id.cv3);
        cv4=(CardView)rootView.findViewById(R.id.cv4);
        cv5=(CardView)rootView.findViewById(R.id.cv5);
        cv6=(CardView)rootView.findViewById(R.id.cv6);
        cv7=(CardView)rootView.findViewById(R.id.cv7);
        cv8=(CardView)rootView.findViewById(R.id.cv8);
        cv9=(CardView)rootView.findViewById(R.id.cv9);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.container);
                viewPager.setCurrentItem(2);
            }
        });

    }


    private class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int pos) {
            int position = pos % (mResources.length);
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(mResources[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int pos, Object object) {
            container.removeView((LinearLayout) object);
            int position = pos % (mResources.length);
        }
    }

}


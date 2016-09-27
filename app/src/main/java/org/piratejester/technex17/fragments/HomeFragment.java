package org.piratejester.technex17.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.piratejester.technex17.R;
import org.piratejester.technex17.adapters.NavigHomeAdapter;
import org.piratejester.technex17.adapters.RecyclerItemClickListener;

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
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.navig_recycler);

        String[] titles = {"Events",
                "Guest Lectures",
                "Workshops",
                "StartUp Fair",
                "Video Wall", "Startup Fair",
                "Guest Lectures",
                "Workshops"
        };
        String[] subtitles = {"Aim for Glory",
                "Soak in the Wisdom",
                "Learn by Fun",
                "An Awesome Beginning",
                "Lets get graphic",
                "Ringa Ringa Roses",
                "Pocket Full of Poises",
                "Atishu Atishu",
                "We all fall down"
        };
        Bitmap[] icons = {BitmapFactory.decodeResource(getResources(), R.drawable.trophy_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.lecture_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.workshop_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.rocket_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.video_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.news_2_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.user_m_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.home_white)
        };
        int[] colors = {getResources().getColor(R.color.md_red_trans),
                getResources().getColor(R.color.md_green_trans),
                getResources().getColor(R.color.md_deep_orange_trans),
                getResources().getColor(R.color.md_indigo_trans),
                getResources().getColor(R.color.md_teal_trans),
                getResources().getColor(R.color.md_pink_trans),
                getResources().getColor(R.color.md_purple_trans),
                getResources().getColor(R.color.md_blue_trans)
        };


        RecyclerView.LayoutManager mLayoutManager;
        mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        NavigHomeAdapter navigHomeAdapter = new NavigHomeAdapter(titles, subtitles, icons, colors);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("Clicked", "" + position);
                        ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.container);
                        viewPager.setCurrentItem(2);
                    }
                })
        );
        recyclerView.setAdapter(navigHomeAdapter);

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


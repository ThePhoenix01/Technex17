package org.piratejester.technex17.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import org.piratejester.technex17.R;
import org.piratejester.technex17.activities.Gallery;
import org.piratejester.technex17.activities.LoginActivity;
import org.piratejester.technex17.activities.WaitAcitivity;

import java.util.HashMap;

/**
 * Created by root on 18/9/16.
 */
public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    public HomeFragment() {
    }

    View rootView;
    ViewPager viewPager;
    private SliderLayout mCarousel;
    LinearLayout carousel_control;
    FrameLayout carousel_home;
    FloatingActionButton play, stop, list;
    ImageButton logout;
    private String MY_PREFS_NAME="MyPrefsFile";

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public int open_stat= 0;
    public int play_stat= 1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rootView = view;
        viewPager = (ViewPager)getActivity().findViewById(R.id.container);
        carousel_home = (FrameLayout) rootView.findViewById(R.id.carousel_home);
        carousel_control = (LinearLayout)rootView.findViewById(R.id.carousel_frame);
        carousel_control.setVisibility(View.GONE);
        open_stat=0;

        play = (FloatingActionButton)rootView.findViewById(R.id.play);
        stop = (FloatingActionButton)rootView.findViewById(R.id.stop);
        list = (FloatingActionButton)rootView.findViewById(R.id.list);

        carousel_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_stat=0;
                carousel_control.setVisibility(View.GONE);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_stat=0;
                carousel_control.setVisibility(View.GONE);
                mCarousel.startAutoCycle();
                if(play_stat==0){
                    Toast.makeText(getActivity(),"Slideshow Resumed",Toast.LENGTH_SHORT).show();
                }
                play_stat=1;
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_stat=0;
                carousel_control.setVisibility(View.GONE);
                mCarousel.stopAutoCycle();
                if(play_stat==1){
                    Toast.makeText(getActivity(),"Slideshow Paused",Toast.LENGTH_SHORT).show();
                }
                play_stat=0;
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_stat=0;
                carousel_control.setVisibility(View.GONE);
                mCarousel.stopAutoCycle();
                viewPager.setCurrentItem(1);
            }
        });

        logout = (ImageButton) rootView.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
                editor.putBoolean("LoginStat",false);
                editor.apply();
                Toast.makeText(getActivity(),"Logged Out Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        carousel();
        setupNavigRecyclerView();

        return rootView;
    }

    private void carousel(){

        mCarousel = (SliderLayout)rootView.findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.carousel1);
        file_maps.put("Big Bang Theory",R.drawable.carousel2);
        file_maps.put("House of Cards",R.drawable.carousel3);
        file_maps.put("Game of Thrones", R.drawable.carousel2);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mCarousel.addSlider(textSliderView);
        }
        mCarousel.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mCarousel.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mCarousel.setCustomAnimation(new DescriptionAnimation());
        mCarousel.setDuration(4000);
        mCarousel.addOnPageChangeListener(this);

    }


    @Override
    public void onStart() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mCarousel.startAutoCycle();
        play_stat=1;
        super.onStart();
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mCarousel.stopAutoCycle();
        play_stat=0;
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {
        Log.d("OnSliderClick","True");
        if(open_stat==0){
            carousel_control.setVisibility(View.VISIBLE);
            open_stat=1;
            Log.d("OnSliderClick","True,0");

        }
        else if(open_stat==1){
            carousel_control.setVisibility(View.GONE);
            open_stat=0;
            mCarousel.startAutoCycle();
            Log.d("OnSliderClick","True,1");
        }
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
                viewPager.setCurrentItem(2);
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workshop_intent=new Intent(getActivity(), WaitAcitivity.class);
                startActivity(workshop_intent);
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workshop_intent=new Intent(getActivity(), WaitAcitivity.class);
                startActivity(workshop_intent);
            }
        });
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workshop_intent=new Intent(getActivity(), WaitAcitivity.class);
                startActivity(workshop_intent);
            }
        });
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workshop_intent=new Intent(getActivity(), WaitAcitivity.class);
                startActivity(workshop_intent);
            }
        });
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workshop_intent=new Intent(getActivity(), WaitAcitivity.class);
                startActivity(workshop_intent);
            }
        });

        cv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workshop_intent=new Intent(getActivity(), Gallery.class);
                startActivity(workshop_intent);
            }
        });
        cv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workshop_intent=new Intent(getActivity(), WaitAcitivity.class);
                startActivity(workshop_intent);
            }
        });
        cv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workshop_intent=new Intent(getActivity(), WaitAcitivity.class);
                startActivity(workshop_intent);
            }
        });
    }



}


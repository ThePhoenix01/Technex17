package org.piratejester.technex17.activities;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import org.piratejester.technex17.R;
import org.piratejester.technex17.fragments.EventFragment;
import org.piratejester.technex17.fragments.HomeFragment;
import org.piratejester.technex17.fragments.NewsFragment;
import org.piratejester.technex17.fragments.UserFragment;

public class HomeActivity extends AppCompatActivity {

    private int pos;
    ImageButton home,news,user,events;
    ViewPager viewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        viewPager = (ViewPager)findViewById(R.id.container);

        home=(ImageButton)findViewById(R.id.home_tab);
        news=(ImageButton)findViewById(R.id.news_tab);
        events=(ImageButton)findViewById(R.id.events_tab);
        user=(ImageButton)findViewById(R.id.dash_tab);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.animate();
                viewPager.setCurrentItem(0);
                home.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.home_black));
                news.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.news_2_white));
                events.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.trophy_white));
                user.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.user_m_white));
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
                news.animate();
                home.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.home_white));
                news.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.news_black));
                events.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.trophy_white));
                user.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.user_m_white));
            }
        });


        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
                events.animate();
                home.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.home_white));
                news.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.news_2_white));
                events.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.trophy_black));
                user.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.user_m_white));
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
                user.animate();
                home.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.home_white));
                news.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.news_2_white));
                events.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.trophy_white));
                user.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.user_m_black));
            }
        });


        /*switch (pos){
            case 0:
                home.setBackgroundColor(getResources().getColor(R.color.transparent_black_percent_50));
            case 1:
                news.setBackgroundColor(getResources().getColor(R.color.transparent_black_percent_50));
            case 2:
                events.setBackgroundColor(getResources().getColor(R.color.transparent_black_percent_50));
            case 3:
                user.setBackgroundColor(getResources().getColor(R.color.transparent_black_percent_50));
        }*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notif) {
            Intent i = new Intent(HomeActivity.this, NotificationActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            pos =position;
            switch (position) {
                case 0:
                    return HomeFragment.newInstance();
                case 1:
                    return NewsFragment.newInstance();
                case 2:
                    return EventFragment.newInstance();
                case 3:
                    return UserFragment.newInstance();
                default:
                    return HomeFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            pos =position;
            iconista();
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
    public void iconista(){

    }
}

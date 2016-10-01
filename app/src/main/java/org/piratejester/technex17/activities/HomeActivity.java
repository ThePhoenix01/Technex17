package org.piratejester.technex17.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

    private int pos, back_count=0;
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
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            int iconId = -1;
            switch (i) {
                case 0:
                    iconId = R.drawable.home_white;
                    break;
                case 1:
                    iconId = R.drawable.news_2_white;
                    break;
                case 2:
                    iconId = R.drawable.trophy_white;
                    break;
                default:
                    iconId = R.drawable.user_m_white;
                    break;
            }
            tabLayout.getTabAt(i).setIcon(iconId);
        }

// Needed since support libraries version 23.0.0
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
            }
        });

/*
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.animate();
                viewPager.setCurrentItem(0);
                *//*
*/
/*home.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.home_black));
                news.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.news_2_white));
                events_mat.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.trophy_white));
                user.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.user_m_white));*//*
*/
/*
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
                news.animate();
                *//*
*/
/*home.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.home_white));
                news.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.news_black));
                events_mat.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.trophy_white));
                user.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.user_m_white));*//*
*/
/*
            }
        });


        events_mat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
                events_mat.animate();
                *//*
*/
/*home.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.home_white));
                news.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.news_2_white));
                events_mat.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.trophy_black));
                user.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.user_m_white));*//*
*/
/*
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
                user.animate();
                *//*
*/
/*home.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.home_white));
                news.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.news_2_white));
                events_mat.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.trophy_white));
                user.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.user_m_black));*//*
*/
/*
            }
        });

*/

    }
/*
    public void tabselector(int pos){
        View home_view = findViewById(R.id.home_view);
        View news_view = findViewById(R.id.news_view);
        View event_view = findViewById(R.id.events_view);
        View user_view = findViewById(R.id.dash_view);
        home_view.setVisibility(View.VISIBLE);
        news_view.setVisibility(View.GONE);
        event_view.setVisibility(View.GONE);
        user_view.setVisibility(View.GONE);


        switch (pos){
            case 0:
                Log.d("Swapped Pos = ",pos+"");

                home_view.setVisibility(View.VISIBLE);
                news_view.setVisibility(View.GONE);
                event_view.setVisibility(View.GONE);
                user_view.setVisibility(View.GONE);
                break;
            case 1:
                Log.d("Swapped Pos = ",pos+"");
                home_view.setVisibility(View.GONE);
                news_view.setVisibility(View.VISIBLE);
                event_view.setVisibility(View.GONE);
                user_view.setVisibility(View.GONE);
                break;
            case 2:
                Log.d("Swapped Pos = ",pos+"");
                home_view.setVisibility(View.GONE);
                news_view.setVisibility(View.GONE);
                event_view.setVisibility(View.VISIBLE);
                user_view.setVisibility(View.GONE);
                break;
            case 3:
                Log.d("Swapped Pos = ",pos+"");
                home_view.setVisibility(View.GONE);
                news_view.setVisibility(View.GONE);
                event_view.setVisibility(View.GONE);
                user_view.setVisibility(View.VISIBLE);
                break;

        }

    }*/

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
        public int getItemPosition(Object object) {
            Log.d("Swapped Pos = ",getItemPosition(object)+"");
            return super.getItemPosition(object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "HOME";
                case 1:
                    return "NEWS";
                case 2:
                    return "EVENTS";
                case 3:
                    return "ME";
                default:
                    return "ME";
            }


        }
    }

    @Override
    public void onBackPressed() {
        if(back_count==0){
            back_count=1;
            View view;
            view=findViewById(R.id.main_content);
            Snackbar.make(view, "Tap back again to exit", Snackbar.LENGTH_LONG).show();
            Thread tim=new Thread(){
                public void run(){
                    try{
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        back_count=0;
                    }
                }
            };
            tim.start();

        }
        else {
            finish();
            super.onBackPressed();
        }
    }
}

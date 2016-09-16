package org.piratejester.technex17.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.piratejester.technex17.R;
import org.piratejester.technex17.adapters.NavigHomeAdapter;
import org.piratejester.technex17.adapters.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    int[] mResources = {R.drawable.carousel2,
            R.drawable.carousel1,
            R.drawable.carousel3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupNavigRecyclerView();
        setupNotifRecyclerView();


    }

    private void setupNotifRecyclerView() {

        mCustomPagerAdapter = new CustomPagerAdapter(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);


    }

    private void setupNavigRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.navig_recycler);

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

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        NavigHomeAdapter navigHomeAdapter = new NavigHomeAdapter(titles, subtitles, icons, colors);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("Clicked", "" + position);
                        Intent intent = new Intent(MainActivity.this,Events.class);
                        intent.putExtra("POSITION",position);
                        startActivity(intent);
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
            int position = pos%(mResources.length);
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(mResources[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int pos, Object object) {
            container.removeView((LinearLayout) object);
            int position = pos%(mResources.length);
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent i = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

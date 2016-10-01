package org.piratejester.technex17.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.piratejester.technex17.R;
import org.piratejester.technex17.adapters.GalleryAdapter;
import org.piratejester.technex17.adapters.RecyclerItemClickListener;
import org.piratejester.technex17.utils.BoldModTextView;
import org.piratejester.technex17.utils.ModTextView;

public class Gallery extends AppCompatActivity {

    RecyclerView galleryRecycler;
    StaggeredGridLayoutManager gridLayoutManager;
    RecyclerView.Adapter adapter;
    boolean overlay=false;
    View overview;
    LinearLayout imageview;
    ImageView zoom;
    BoldModTextView title; ModTextView date;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Uploading...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageview = (LinearLayout) findViewById(R.id.imageview);
        overview = findViewById(R.id.overlay);
        imageview.setVisibility(View.GONE);
        overview.setVisibility(View.GONE);
        title = (BoldModTextView) findViewById(R.id.title);
        date = (ModTextView) findViewById(R.id.time);
        zoom = (ImageView) findViewById(R.id.iv_zoom);

        overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overlay=false;
                imageview.setVisibility(View.GONE);
                overview.setVisibility(View.GONE);
                fab.setVisibility(View.VISIBLE);
            }
        });

        final String[] names_list= {"Robowars", "Hydracs", "Pixelate", "Robohunt","Robowars", "Hydracs", "Pixelate", "Robohunt"};
        final String[] date_list= {"May 10", "July 04", "Sep 20", "Jan 01","Oct 31", "Feb 24", "Feb 25", "Feb 26"};
        final Bitmap[] images_list = {
                BitmapFactory.decodeResource(getResources(), R.drawable.user_m_black),
                BitmapFactory.decodeResource(getResources(), R.drawable.aero),
                BitmapFactory.decodeResource(getResources(), R.drawable.robo),
                BitmapFactory.decodeResource(getResources(), R.drawable.sae),
                BitmapFactory.decodeResource(getResources(), R.drawable.sae),
                BitmapFactory.decodeResource(getResources(), R.drawable.aero),
                BitmapFactory.decodeResource(getResources(), R.drawable.robo),
                BitmapFactory.decodeResource(getResources(), R.drawable.sae)
        };
/*        getActivity(), LinearLayoutManager.VERTICAL, false
        3,StaggeredGridLayoutManager.VERTICAL*/
        galleryRecycler = (RecyclerView)findViewById(R.id.recycler_imagegallery);
        gridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        galleryRecycler.setLayoutManager(gridLayoutManager);
        adapter = new GalleryAdapter(names_list,images_list);
        galleryRecycler.setAdapter(adapter);
        galleryRecycler.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("Clicked", "" + position);
                        overlay=true;
                        zoom.setImageBitmap(images_list[position]);
                        title.setText(names_list[position]);
                        date.setText(date_list[position]);
                        imageview.setVisibility(View.VISIBLE);
                        overview.setVisibility(View.VISIBLE);
                        fab.setVisibility(View.GONE);


                    }
                })
        );
    }

    @Override
    public void onBackPressed() {

        if(overlay){
            overlay=false;
            imageview.setVisibility(View.GONE);
            overview.setVisibility(View.GONE);
            fab.setVisibility(View.VISIBLE);

        }
        else{
            super.onBackPressed();
        }

    }
}

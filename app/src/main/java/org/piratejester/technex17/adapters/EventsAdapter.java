package org.piratejester.technex17.adapters;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.piratejester.technex17.utils.BoldModTextView;

import org.piratejester.technex17.R;

/**
 * Created by Soumyadeep on 02-Dec-15.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private String[] mName, mSubs;
    private int[] mRating;
    private Bitmap[] mBitmaps,mLogo,mBg;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View mView;
        BoldModTextView name_text;
        ImageView bg_img;
        ImageView logo_img;
        public ViewHolder(View v){
            super(v);
            name_text=(BoldModTextView)v.findViewById(R.id.tv_events);
            bg_img=(ImageView)v.findViewById(R.id.iv_events_icon);
            logo_img=(ImageView)v.findViewById(R.id.iv_events);
            mView=v;
        }
    }

    public EventsAdapter(String[] name_text, Bitmap[] bg_image, Bitmap[] logo_img){
        mName=name_text;
        mLogo=logo_img;
        mBg=bg_image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_events, parent, false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return mName.length;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name_text.setText(mName[position]);
        holder.bg_img.setImageBitmap(mBg[position]);
        holder.logo_img.setImageBitmap(mLogo[position]);
    }
}

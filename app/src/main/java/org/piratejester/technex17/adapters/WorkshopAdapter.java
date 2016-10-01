package org.piratejester.technex17.adapters;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.piratejester.technex17.R;
import org.piratejester.technex17.utils.BoldModTextView;


/**
 * Created by root on 1/10/16.
 */




public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ViewHolder> {
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
            bg_img=(ImageView)v.findViewById(R.id.iv_workshop);
            logo_img=(ImageView)v.findViewById(R.id.iv_workshop_icon);
            mView=v;
        }
    }

    public WorkshopAdapter(String[] name_text, Bitmap[] bg_image, Bitmap[] logo_img){
        mName=name_text;
        mLogo=logo_img;
        mBg=bg_image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_workshops, parent, false);
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

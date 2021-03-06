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
import org.piratejester.technex17.utils.ModTextView;

/**
 * Created by Soumyadeep on 02-Dec-15.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private String[] mName, me1, me2,me3;
    private int[] mRating;
    private Bitmap[] mBitmaps,mLogo,mBg;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View mView;
        BoldModTextView name_text;
        ModTextView event1,event2,event3;
        ImageView bg_img;
        ImageView logo_img;
        public ViewHolder(View v){
            super(v);
            name_text=(BoldModTextView)v.findViewById(R.id.tv_events);
            bg_img=(ImageView)v.findViewById(R.id.iv_events_icon);
            logo_img=(ImageView)v.findViewById(R.id.iv_events);
            event1=(ModTextView)v.findViewById(R.id.e1);
            event2=(ModTextView)v.findViewById(R.id.e2);
            event3=(ModTextView)v.findViewById(R.id.e3);
            mView=v;
        }
    }

    public EventsAdapter(String[] name_text, Bitmap[] bg_image, Bitmap[] logo_img, String[] e1,String[] e2,String[] e3){
        mName=name_text;
        mLogo=logo_img;
        mBg=bg_image;
        me1=e1;
        me2=e2;
        me3=e3;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_events, parent, false);
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
        holder.event1.setText(me1[position]);
        holder.event2.setText(me2[position]);
        holder.event3.setText(me3[position]);
    }
}

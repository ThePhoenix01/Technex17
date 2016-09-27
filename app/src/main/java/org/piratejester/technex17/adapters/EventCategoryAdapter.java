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
import org.piratejester.technex17.utils.ModTextView;

/**
 * Created by Soumyadeep on 02-Dec-15.
 */
public class EventCategoryAdapter extends RecyclerView.Adapter<EventCategoryAdapter.ViewHolder> {
    private String[] mName, mDesc, mTime;
    private int[] mPrize, mTeam;
    private Bitmap[] mBg;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View mView;
        BoldModTextView name_text;
        ModTextView desc_text, team_text, prize_text, time_text;
        ImageView bg_img;
        public ViewHolder(View v){
            super(v);
            name_text=(BoldModTextView)v.findViewById(R.id.tv_events);
            desc_text=(ModTextView)v.findViewById(R.id.tv_desc);
            team_text=(ModTextView)v.findViewById(R.id.team_text);
            prize_text=(ModTextView)v.findViewById(R.id.prize_text);
            time_text=(ModTextView)v.findViewById(R.id.time_text);
            bg_img=(ImageView)v.findViewById(R.id.iv_events);
            mView=v;
        }
    }

    public EventCategoryAdapter(String[] name_text, String[] desc_text,int[] team_text,int[] prize_text,String[] time_text, Bitmap[] bg_image){
        mName=name_text;
        mDesc=desc_text;
        mTeam=team_text;
        mPrize=prize_text;
        mTime=time_text;
        mBg=bg_image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_eventhead, parent, false);
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
        holder.desc_text.setText(mDesc[position]);
        holder.team_text.setText("Maximum Members : "+mTeam[position]);
        holder.prize_text.setText("Prize : "+mPrize[position]);
        holder.time_text.setText("Deadline : " + mTime[position]);
        holder.bg_img.setImageBitmap(mBg[position]);
    }
}

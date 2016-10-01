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
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
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
            name_text=(BoldModTextView)v.findViewById(R.id.tv_image);
            bg_img=(ImageView)v.findViewById(R.id.iv_image);
            mView=v;
        }
    }

    public GalleryAdapter(String[] name_text, Bitmap[] bg_image){
        mName=name_text;
        mBg=bg_image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_gallery, parent, false);
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
    }
}

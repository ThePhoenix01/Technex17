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
import org.piratejester.technex17.utils.ModTextView;

/**
 * Created by Soumyadeep on 02-Dec-15.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private String[] mField, mValue;
    private Bitmap[] mLogo;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ModTextView field_text,value_text;
        View mView;
        ImageView logo_img;
        public ViewHolder(View v){
            super(v);
            field_text=(ModTextView)v.findViewById(R.id.field_text);
            value_text=(ModTextView)v.findViewById(R.id.value_text);
            logo_img=(ImageView)v.findViewById(R.id.iv_logo);
            mView=v;
        }
    }

    public UserAdapter(String[] field_text, String[] value_text,Bitmap[] logo){
        mField=field_text;
        mValue=value_text;
        mLogo=logo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user, parent, false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return mValue.length;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.field_text.setText(mField[position]);
        holder.value_text.setText(mValue[position]);
        holder.logo_img.setImageBitmap(mLogo[position]);
    }
}

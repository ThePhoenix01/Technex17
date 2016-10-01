package org.piratejester.technex17.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.piratejester.technex17.R;
import org.piratejester.technex17.activities.HomeActivity;

/**
 * Created by root on 18/9/16.
 */
public class SigninFragment extends Fragment{
    public SigninFragment() {

    }

    public static SigninFragment newInstance() {
        SigninFragment fragment = new SigninFragment();
        return fragment;
    }

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private String MY_PREFS_NAME="MyPrefsFile";
    ViewPager viewPager;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);

        viewPager = (ViewPager)getActivity().findViewById(R.id.container);
        this.imageView = (ImageView)rootView.findViewById(R.id.imageviewreg);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

            }
        });

        Button regButton = (Button)rootView.findViewById(R.id.reg_but);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
                editor.putBoolean("LoginStat",true);
                editor.apply();
                Toast.makeText(getActivity(),"Registed Successfully",Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });
        Button logBut = (Button)rootView.findViewById(R.id.log_but);
        logBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        return rootView;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == getActivity().RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            photo=getRoundedCornerBitmap(photo);
            imageView.setImageBitmap(photo);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setMaxWidth(50);
            imageView.setMaxHeight(50);
        }
    }


    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 12;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }
}

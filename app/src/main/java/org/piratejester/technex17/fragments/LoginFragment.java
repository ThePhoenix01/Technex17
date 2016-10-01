package org.piratejester.technex17.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.piratejester.technex17.R;
import org.piratejester.technex17.activities.HomeActivity;

/**
 * Created by root on 18/9/16.
 */
public class LoginFragment extends Fragment{
    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    private String MY_PREFS_NAME="MyPrefsFile";
    ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        viewPager = (ViewPager)getActivity().findViewById(R.id.container);

        Button logButton = (Button)rootView.findViewById(R.id.log_but);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
                editor.putBoolean("LoginStat",true);
                editor.apply();
                Toast.makeText(getActivity(),"Logged In Successfully",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                getActivity().finish();
            }
        });

        Button signButton = (Button)rootView.findViewById(R.id.sign_but);
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        Button fogButton = (Button)rootView.findViewById(R.id.forgot_butt);
        fogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

                // set title
                /*alertDialogBuilder.setTitle("CONFIRM COUPONS");*/

                // create alert dialog
                final AlertDialog alertDialog = alertDialogBuilder.create();
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_forgot_password, null);
                alertDialog.setView(dialogView);

                final Button proceed, cancel;

                /*proceed=(Button)dialogView.findViewById(R.id.proceed);
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().finish();
                    }
                });
                cancel=(Button)dialogView.findViewById(R.id.cancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogInterface dialog = alertDialog;
                        dialog.cancel();
                    }
                });*/
                // show i
                alertDialog.show();

            }
        });

        return rootView;
    }
}

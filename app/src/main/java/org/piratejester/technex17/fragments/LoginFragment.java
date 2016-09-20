package org.piratejester.technex17.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.piratejester.technex17.R;
import org.piratejester.technex17.activities.HomeActivity;

/**
 * Created by root on 18/9/16.
 */
public class LoginFragment extends Fragment{
    public LoginFragment() {
    }



    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        Button logButton = (Button)rootView.findViewById(R.id.log_but);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return rootView;
    }
}

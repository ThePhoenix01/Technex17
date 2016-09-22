package org.piratejester.technex17.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.piratejester.technex17.R;

/**
 * Created by root on 18/9/16.
 */
public class UserFragment extends Fragment {

    public UserFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);

        /*final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (56 * scale + 0.5f);
        AppBarLayout appBarLayout = (AppBarLayout)getActivity().findViewById(R.id.app_bar);
        appBarLayout.getLayoutParams().height = pixels;
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.getLayoutParams().height = 0;*/

/*        RecyclerView mUserDetailRecycler,mUserTeamRecycler;
        RecyclerView.Adapter mUserDetailAdapter,mUserTeamAdapter;
        RecyclerView.LayoutManager mDetailLayoutManager,mTeamLayoutManager;

        String[] field = {"Name","College","City"};
        String[] value = {"Sir Phoenix de Tauroville","Hogwarts","Hogsmead"};
        Bitmap logo[] = {
                BitmapFactory.decodeResource(getResources(), R.drawable.user_m_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.user_m_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.user_m_white),
                BitmapFactory.decodeResource(getResources(), R.drawable.user_m_white)
        };

        mUserDetailRecycler = (RecyclerView) rootView.findViewById(R.id.userdetail_recycler);
        mDetailLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mUserDetailRecycler.setLayoutManager(mDetailLayoutManager);
        mUserDetailAdapter = new UserAdapter(field, value, logo);
        mUserDetailRecycler.setAdapter(mUserDetailAdapter);
        *//*mUserDetailRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("Clicked", "" + position);
                        Intent intent = new Intent(getActivity(),EventDetail.class);
                        intent.putExtra("POSITION",position);
                        startActivity(intent);
                    }
                })
        );
*//*
        mUserTeamRecycler = (RecyclerView) rootView.findViewById(R.id.userteam_recycler);
        mTeamLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mUserTeamRecycler.setLayoutManager(mTeamLayoutManager);
        mUserTeamAdapter = new UserAdapter(field, value, logo);
        mUserTeamRecycler.setAdapter(mUserTeamAdapter);
        *//*mUserTeamRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("Clicked", "" + position);
                        Intent intent = new Intent(getActivity(),EventDetail.class);
                        intent.putExtra("POSITION",position);
                        startActivity(intent);
                    }
                })
        );*/

        return rootView;
    }
}

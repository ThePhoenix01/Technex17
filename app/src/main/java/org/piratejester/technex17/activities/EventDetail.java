package org.piratejester.technex17.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.piratejester.technex17.R;
import org.piratejester.technex17.adapters.EventDetailAdapter;
import org.piratejester.technex17.adapters.RecyclerItemClickListener;
import org.piratejester.technex17.fragments.EventRegFragment;

public class EventDetail extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabTextColors();
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_event_detail, container, false);

            RecyclerView mEventRecycler;
            RecyclerView.Adapter mEventAdapter;
            RecyclerView.LayoutManager mEventLayoutManager;

            String[] title = {"Details"};
            String[] body = {"A material metaphor is the unifying theory of a rationalized space and a system of motion." +
                    "The material is grounded in tactile reality, inspired by the study of paper and ink, yet " +
                    "technologically advanced and open to imagination and magic.\n" +
                    "Surfaces and edges of the material provide visual cues that are grounded in reality. The " +
                    "use of familiar tactile attributes helps users quickly understand affordances. Yet the " +
                    "flexibility of the material creates new affordances that supercede those in the physical " +
                    "world, without breaking the rules of physics.\n" +
                    "The fundamentals of light, surface, and movement are key to conveying how objects move, " +
                    "interact, and exist in space and in relation to each other. Realistic lighting shows " +
                    "seams, divides space, and indicates moving parts.\n\n"+
                    "A material metaphor is the unifying theory of a rationalized space and a system of motion." +
                            "The material is grounded in tactile reality, inspired by the study of paper and ink, yet " +
                            "technologically advanced and open to imagination and magic.\n" +
                            "Surfaces and edges of the material provide visual cues that are grounded in reality. The " +
                            "use of familiar tactile attributes helps users quickly understand affordances. Yet the " +
                            "flexibility of the material creates new affordances that supercede those in the physical " +
                            "world, without breaking the rules of physics.\n" +
                            "The fundamentals of light, surface, and movement are key to conveying how objects move, " +
                            "interact, and exist in space and in relation to each other. Realistic lighting shows " +
                            "seams, divides space, and indicates moving parts.\n\n" +
                            "A material metaphor is the unifying theory of a rationalized space and a system of motion." +
                            "The material is grounded in tactile reality, inspired by the study of paper and ink, yet " +
                            "technologically advanced and open to imagination and magic.\n" +
                            "Surfaces and edges of the material provide visual cues that are grounded in reality. The " +
                            "use of familiar tactile attributes helps users quickly understand affordances. Yet the " +
                            "flexibility of the material creates new affordances that supercede those in the physical " +
                            "world, without breaking the rules of physics.\n" +
                            "The fundamentals of light, surface, and movement are key to conveying how objects move, " +
                            "interact, and exist in space and in relation to each other. Realistic lighting shows " +
                            "seams, divides space, and indicates moving parts.\n\n" +
                            "Bold, graphic, intentional.\n\n" +
                            "The foundational elements of print based design typography, grids, space, scale, color, " +
                            "and use of imagery guide visual treatments. These elements do far more than please the " +
                            "eye. They create hierarchy, meaning, and focus. Deliberate color choices, edge to edge " +
                            "imagery, large scale typography, and intentional white space create a bold and graphic " +
                            "interface that immerse the user in the experience.\n" +
                            "An emphasis on user actions makes core functionality immediately apparent and provides " +
                            "waypoints for the user.\n\n" +
                            "Motion provides meaning.\n\n",

                   /* "Motion respects and reinforces the user as the prime mover. Primary user actions are " +
                            "inflection points that initiate motion, transforming the whole design.\n" +
                            "All action takes place in a single environment. Objects are presented to the user without " +
                            "breaking the continuity of experience even as they transform and reorganize.\n" +
                            "Motion is meaningful and appropriate, serving to focus attention and maintain continuity. " +
                            "Feedback is subtle yet clear. Transitions are efﬁcient yet coherent.\n\n" +
                            "3D world.\n\n" +
                            "The material environment is a 3D space, which means all objects have x, y, and z " +
                            "dimensions. The z-axis is perpendicularly aligned to the plane of the display, with the " +
                            "positive z-axis extending towards the viewer. Every sheet of material occupies a single " +
                            "position along the z-axis and has a standard 1dp thickness.\n" +
                            "On the web, the z-axis is used for layering and not for perspective. The 3D world is " +
                            "emulated by manipulating the y-axis.\n\n" +
                            "Light and shadow.\n\n" +
                            "Within the material environment, virtual lights illuminate the scene. Key lights create " +
                            "directional shadows, while ambient light creates soft shadows from all angles.\n" +
                            "Shadows in the material environment are cast by these two light sources. In Android " +
                            "development, shadows occur when light sources are blocked by sheets of material at " +
                            "various positions along the z-axis. On the web, shadows are depicted by manipulating the " +
                            "y-axis only. The following example shows the card with a height of 6dp.\n\n" +
                            "Resting elevation.\n\n" +
                            "All material objects, regardless of size, have a resting elevation, or default elevation " +
                            "that does not change. If an object changes elevation, it should return to its resting " +
                            "elevation as soon as possible.\n\n" +
                            "Component elevations.\n\n" +
                            "The resting elevation for a component type is consistent across apps (e.g., FAB elevation " +
                            "does not vary from 6dp in one app to 16dp in another app).\n" +
                            "Components may have different resting elevations across platforms, depending on the depth " +
                            "of the environment (e.g., TV has a greater depth than mobile or desktop).\n\n" +
                            "Responsive elevation and dynamic elevation offsets.\n\n",

                    "Some component types have responsive elevation, meaning they change elevation in response " +
                            "to user input (e.g., normal, focused, and pressed) or system events_mat. These elevation " +
                            "changes are consistently implemented using dynamic elevation offsets.\n" +
                            "Dynamic elevation offsets are the goal elevation that a component moves towards, relative " +
                            "to the component’s resting state. They ensure that elevation changes are consistent " +
                            "across actions and component types. For example, all components that lift on press have " +
                            "the same elevation change relative to their resting elevation.\n" +
                            "Once the input event is completed or cancelled, the component will return to its resting " +
                            "elevation.\n\n" +
                            "Avoiding elevation interference.\n\n"*/
            };

            /*Bitmap background[] = {
                    BitmapFactory.decodeResource(getResources(), R.drawable.sae),
                    BitmapFactory.decodeResource(getResources(), R.drawable.aero),
                    BitmapFactory.decodeResource(getResources(), R.drawable.robo),
                    BitmapFactory.decodeResource(getResources(), R.drawable.sae)
            };*/

            /*Bitmap icon1 = BitmapFactory.decodeResource(getResources(), R.drawable.cart_outline);
            Bitmap icons[] = {icon1, icon1, icon1, icon1};*/

            mEventRecycler = (RecyclerView) rootView.findViewById(R.id.my_recycler_view_1);
            mEventLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            mEventRecycler.setLayoutManager(mEventLayoutManager);
            mEventAdapter = new EventDetailAdapter(title,body);
            mEventRecycler.setAdapter(mEventAdapter);
            mEventRecycler.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Log.d("Clicked", "" + position);
                            /*Intent intent = new Intent(getActivity(),EventActivity.class);
                            intent.putExtra("POSITION",position);
                            startActivity(intent);*/
                        }
                    })
            );

            /*LinearLayout frag_layout = (LinearLayout)rootView.findViewById(R.id.layout_detail_frag);
            BoldModTextView title = (BoldModTextView)rootView.findViewById(R.id.title);

            int[] colors = {getResources().getColor(R.color.md_red_trans),
                    getResources().getColor(R.color.md_green_trans),
                    getResources().getColor(R.color.md_deep_orange_trans),
                    getResources().getColor(R.color.md_teal_trans),
                    getResources().getColor(R.color.md_pink_trans),
            };

            String[] titles={"Introduction", "Event Structure", "Problem Statement", "Register","Contact Us"};

            frag_layout.setBackgroundColor(colors[getArguments().getInt(ARG_SECTION_NUMBER)]);

            title.setText(titles[getArguments().getInt(ARG_SECTION_NUMBER)]);*/
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position==3){
                return EventRegFragment.newInstance();
            }
            else{
                return PlaceholderFragment.newInstance(position);
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "INTRODUCTION";
                case 1:
                    return "EVENT STRUCTURE";
                case 2:
                    return "PROBLEM STATEMENT";
                case 3:
                    return "REGISTER";
                case 4:
                    return "CONTACT US";
            }
            return null;
        }
    }
}

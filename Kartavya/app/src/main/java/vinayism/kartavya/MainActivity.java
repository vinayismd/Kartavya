package vinayism.kartavya;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Handler;


public class MainActivity extends ActionBarActivity {

    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    TextView maintext , desc;

    //sliding image
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNavItems.add(new NavItem("About", "Info about Kartavya", R.drawable.about));
        mNavItems.add(new NavItem("Center", "Info of centres", R.drawable.centr));
        mNavItems.add(new NavItem("Achievements", "Children Achivements", R.drawable.pin));
        mNavItems.add(new NavItem("Members", "Get Members Details", R.drawable.members));
        mNavItems.add(new NavItem("Register", "For new Members", R.drawable.register));
        mNavItems.add(new NavItem("Login", "Login here ", R.drawable.login));
        mNavItems.add(new NavItem("Prakash", "Our Annual Fest", R.drawable.prakash));
        mNavItems.add(new NavItem("Other Events", "Info of Other Activities", R.drawable.otherevent));
        mNavItems.add(new NavItem("Sponsors", "Our Sponsors", R.drawable.sponsor));
        mNavItems.add(new NavItem("Internship", "Want to work with us", R.drawable.graduation));




         maintext =(TextView)findViewById(R.id.main_text);
        maintext.setText("Kartavya is a Non-Governmental Organisation providing free and high quality education to underprivileged children living in slums and villages near college campuses. The whole management of the organization is handled by college students. Apart from two-hours evening tuitions to around 500 students with 250 children going to good private schools for formal education." +
                " Kartavya is envisioned to uplift the marginalised citizenry living in slum/village." +"Kartavya has a mission to establish kartavya model in prominent colleges and varsities across the country."
                   );
        //sliding image
        viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new CustomAdapter(MainActivity.this);
        viewPager.setAdapter(adapter);

        desc = (TextView)findViewById(R.id.desc);
        desc.setText("..an effort of college students \ntoward educated India.");

        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // Populate the Navigtion Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter adap = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adap);

        // Drawer Item click listeners
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // selectItemFromDrawer(position);
                String lev = String.valueOf(position);
                String s=mNavItems.get(position).mTitle;
                switch (lev)
                {
                    case "0": {
                        Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this , About.class);
                        startActivity(i);
                        break;
                    }
                    case "1": {
                        Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this , Centre.class);
                        startActivity(i);
                        break;

                    }
                    case "2": {


                        ConnectivityManager connec =
                                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
                        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED )
                        {

                            // if connected with internet
                            Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this , Achievements.class);
                            startActivity(i);


                        }else
                        {
                            Toast.makeText(getApplicationContext() , "NO INTERNET" , Toast.LENGTH_SHORT).show();
                        }
                        break;

                    }
                    case "3": {
                        Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this , Members.class);
                        startActivity(i);
                        break;
                    }
                    case "4": {

                        ConnectivityManager connec =
                                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
                        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED )
                        {

                            Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this , Register.class);
                            startActivity(i);


                        }else
                        {
                            Toast.makeText(getApplicationContext() , "NO INTERNET" , Toast.LENGTH_SHORT).show();
                        }
                        break;

                    }
                    case "5": {

                        ConnectivityManager connec =
                                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
                        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED )
                        {

                            // if connected with internet
                            Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this , Login.class);
                            startActivity(i);


                        }else
                        {
                            Toast.makeText(getApplicationContext() , "NO INTERNET" , Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                    case "6": {
                        Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this , Prakash.class);
                        startActivity(i);
                        break;
                    }
                    case "7": {

                        ConnectivityManager connec =
                                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
                        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED )
                        {

                            Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this , OtherEvents.class);
                            startActivity(i);


                        }else
                        {
                            Toast.makeText(getApplicationContext() , "NO INTERNET" , Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                    case "8": {
                        Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this , Sponsors.class);
                        startActivity(i);
                        break;
                    }
                    case "9": {
                        Toast.makeText(getBaseContext(),s, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this , Internship.class);
                        startActivity(i);
                        break;
                    }
                }



            }

            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            private void selectItemFromDrawer(int position) {

//                Fragment fragment = new PreferencesFragment();
//
//                FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.mainContent, fragment)
//                        .commit();
//
//                mDrawerList.setItemChecked(position, true);
//                setTitle(mNavItems.get(position).mTitle);
//
//                // Close the drawer
//                mDrawerLayout.closeDrawer(mDrawerPane);
            }
        });


    }

    class NavItem {
        String mTitle;
        String mSubtitle;
        int mIcon;

        public NavItem(String title, String subtitle, int icon) {
            mTitle = title;
            mSubtitle = subtitle;
            mIcon = icon;
        }
    }

    class DrawerListAdapter extends BaseAdapter {

        Context mContext;
        ArrayList<NavItem> mNavItems;

        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems) {
            mContext = context;
            mNavItems = navItems;
        }

        @Override
        public int getCount() {
            return mNavItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mNavItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.drawer_item, null);
            } else {
                view = convertView;
            }

            TextView titleView = (TextView) view.findViewById(R.id.title);
            TextView subtitleView = (TextView) view.findViewById(R.id.subTitle);
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);

            titleView.setText(mNavItems.get(position).mTitle);
            subtitleView.setText(mNavItems.get(position).mSubtitle);
            iconView.setImageResource(mNavItems.get(position).mIcon);

            return view;
        }
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
            finish();

    }

}
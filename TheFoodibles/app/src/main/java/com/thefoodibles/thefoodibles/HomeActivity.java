package com.thefoodibles.thefoodibles;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static User user = new User();
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Defines and initializes drawers

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setupnavbar(navigationView);

        //Sets up the welcome screens

        Fragment fragment = new TopFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment, "visible_fragment");
        navigationView.setCheckedItem(R.id.nav_home);
        ft.commit();
    }

    //Applies user profile pic and username on the navbar

    public void setupnavbar(NavigationView navigationView) {
        TextView view;
        view = (TextView) navigationView.getHeaderView(0).findViewById(R.id.usernamenavbar);
        view.setText(user.getUsername());
        view = (TextView) navigationView.getHeaderView(0).findViewById(R.id.emailnavbar);
        view.setText(user.getEmail());
    }

    //What happens when you press back button

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Order.orders = new ArrayList<Order>();
            int count = getFragmentManager().getBackStackEntryCount();
            if(count==0) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            } else {
                getFragmentManager().popBackStack();
                setactionbartitle(0);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment;
        int id = item.getItemId();
        if (id == R.id.nav_profile) {
            fragment = new UserFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, "visible_fragment");
            ft.addToBackStack(null);
            ft.commit();
            setactionbartitle(1);
        } else if (id == R.id.nav_logout) {
            finish();
        } else if (id == R.id.nav_home) {
            fragment = new TopFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, "visible_fragment");
            ft.addToBackStack(null);
            ft.commit();
            setactionbartitle(0);
        } else if (id == R.id.nav_pendingorders) {
            fragment = new PendingFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, "visible_fragment");
            ft.addToBackStack(null);
            ft.commit();
            setactionbartitle(2);
        }

//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setactionbartitle(int position) {
        String title=null;
        if(position==0) {
            title = "TheFoodibles";
            navigationView.setCheckedItem(R.id.nav_home);
        } else if(position == 1){
            title="Profile";
            navigationView.setCheckedItem(R.id.nav_profile);
        } else if(position == 2) {
            title = "Pending Orders";
            navigationView.setCheckedItem(R.id.nav_pendingorders);
        }
        setTitle(title);
    }


    //Methods for home screen
    public void breakfast(View view) {
        MenuFragment.time_pos=0;
        transact();
    }

    public void lunch(View view) {
        MenuFragment.time_pos=1;
        transact();
    }

    public void dinner(View view) {
        MenuFragment.time_pos=2;
        transact();
    }

    public void bulk(View view) {
        MenuFragment.time_pos=3;
        transact();
    }

    private void transact() {
        Fragment fragment = new MenuFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment, "visible_fragment");
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}

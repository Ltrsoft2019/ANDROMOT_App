package com.ltrsoft.andromotapp.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.Utile.SessionActivity;


public class NavigationDrawerfragment extends Fragment {
    public DrawerLayout drawerLayout;
    public Toolbar toolbar;
    public NavigationView navigationView;
    public ActionBarDrawerToggle toggle;

    public NavigationDrawerfragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.navigationfragment, container, false);

       // toolbar = v.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        navigationView = v.findViewById(R.id.navigation);
        drawerLayout = v.findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getContext().getColor(R.color.white));

        Dashboard dashboardFragment = new Dashboard();
        getFragmentManager().beginTransaction().replace(R.id.containermain, dashboardFragment).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);

                if (id == R.id.home) {
                    Dashboard dashboardFragment = new Dashboard();
                    getFragmentManager().beginTransaction().replace(R.id.containermain, dashboardFragment).addToBackStack(null).commit();
                } else if (id == R.id.contact) {
                    getFragmentManager().beginTransaction().replace(R.id.containermain, new Contact_us()).addToBackStack(null).commit();
                } else if (id == R.id.About) {
                    getFragmentManager().beginTransaction().replace(R.id.containermain, new About()).addToBackStack(null).commit();
                } else if (id==R.id.feedback) {
                    getFragmentManager().beginTransaction().replace(R.id.containermain, new FeedbackFragment()).addToBackStack(null).commit();

                }
                else if (id==R.id.help){

                    getFragmentManager().beginTransaction().replace(R.id.containermain, new HelphFragment()).addToBackStack(null).commit();

                }
                else if (id == R.id.logout) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Logout Dialog");
                    builder.setMessage("Do You Want To Logout?");
                    builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences pref = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putBoolean("flag", false).apply();

                            Intent intent = new Intent(getContext(), SessionActivity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        return v;
    }
}

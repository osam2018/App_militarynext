package com.example.user.mil.view.store;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.user.mil.R;

import butterknife.BindView;

public class StoreActivity extends AppCompatActivity {

    @BindView(R.id.store_fragment_container)
    FrameLayout fragmentFrameLayout;

    @BindView(R.id.store_bottom_navigation)
    BottomNavigationView bottomNavigationMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                switch (menuItem.getItemId())  {
                    case R.id.action_store_common:
                        selectedFragment = CommonStoreFragment.newInstance();
                        break;

                    case R.id.action_store_trade:
                        selectedFragment = UsedProductFragment.newInstance();
                        break;

                    case R.id.action_store_sell:
                        selectedFragment =SellFragment.newInstance();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.store_fragment_container, selectedFragment);
                transaction.commit();
                return true;

            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.store_fragment_container, CommonStoreFragment.newInstance());
        transaction.commit();
    }








}

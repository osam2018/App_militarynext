package com.example.user.mil.view.store;


import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.user.mil.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity {

    @BindView(R.id.store_fragment_container)
    FrameLayout fragmentFrameLayout;

    private BottomBar bottomNavigationMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ButterKnife.bind(this);

        BottomBar bottomNavigationMenu = (BottomBar) findViewById(R.id.store_bottom_navigation);
        bottomNavigationMenu.setItems(R.menu.store_navigation_items);
        bottomNavigationMenu.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                Fragment selectedFragment = null;

                switch (menuItemId)  {
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
            }

            @Override
            public void onMenuTabReSelected(int menuItemId) {

            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.store_fragment_container, CommonStoreFragment.newInstance());
        transaction.commit();
    }


}

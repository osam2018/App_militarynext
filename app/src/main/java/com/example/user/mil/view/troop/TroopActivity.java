package com.example.user.mil.view.troop;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.user.mil.R;
import com.example.user.mil.view.community.CommunityActivity;
import com.example.user.mil.view.community.MyPostFragment;
import com.example.user.mil.view.community.NoticeFragment;
import com.example.user.mil.view.community.TimelineFragment;
import com.example.user.mil.view.community.UploadActivity;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TroopActivity extends AppCompatActivity {

    @BindView(R.id.troop_fragment_container)
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troop);
        ButterKnife.bind(this);

        BottomBar bottomNavigationMenu = (BottomBar) findViewById(R.id.troop_bottom_navigation);
        bottomNavigationMenu.setItems(R.menu.troop_navigation_item);
        bottomNavigationMenu.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                Fragment selectedFragment = null;

                switch (menuItemId)  {
                    case R.id.action_troop_planner:
                        selectedFragment = TroopTodoFragment.newInstance();
                        break;

                    case R.id.action_troop_notice:
                        selectedFragment = TroopNoticeFragment.newInstance();
                        break;

                    case R.id.action_troop_group:
                        selectedFragment = TroopGroupFragment.newInstance();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.troop_fragment_container, selectedFragment);
                transaction.commit();
            }

            @Override
            public void onMenuTabReSelected(int menuItemId) {

            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.troop_fragment_container, TimelineFragment.newInstance());
        transaction.commit();
    }

}


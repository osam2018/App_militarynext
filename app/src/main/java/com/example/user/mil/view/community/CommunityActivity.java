package com.example.user.mil.view.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.user.mil.R;
import com.example.user.mil.view.book.PopularBookFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommunityActivity extends AppCompatActivity {

    @BindView(R.id.community_fragment_container)
    FrameLayout frameLayout;

    @OnClick(R.id.add_timeline_button)
    public void uploadTimeline() {
        Intent intent = new Intent(CommunityActivity.this,UploadActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        ButterKnife.bind(this);

        BottomBar bottomNavigationMenu = (BottomBar) findViewById(R.id.community_bottom_navigation);
        bottomNavigationMenu.setItems(R.menu.comuunity_navigation_item);
        bottomNavigationMenu.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                Fragment selectedFragment = null;

                switch (menuItemId)  {
                    case R.id.action_community_timeline:
                        selectedFragment = TimelineFragment.newInstance();
                        break;

                    case R.id.action_community_notice:
                        selectedFragment = NoticeFragment.newInstance();
                        break;

                    case R.id.action_community_my:
                        selectedFragment = MyPostFragment.newInstance();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.community_fragment_container, selectedFragment);
                transaction.commit();
            }

            @Override
            public void onMenuTabReSelected(int menuItemId) {

            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.community_fragment_container, TimelineFragment.newInstance());
        transaction.commit();
    }

}
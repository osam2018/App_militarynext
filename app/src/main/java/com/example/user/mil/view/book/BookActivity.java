package com.example.user.mil.view.book;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.mil.R;
import com.example.user.mil.view.store.CommonStoreFragment;
import com.example.user.mil.view.store.SellFragment;
import com.example.user.mil.view.store.UsedProductFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.ButterKnife;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ButterKnife.bind(this);

        BottomBar bottomNavigationMenu = (BottomBar) findViewById(R.id.book_bottom_navigation);
        bottomNavigationMenu.setItems(R.menu.book_navigation_item);
        bottomNavigationMenu.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                Fragment selectedFragment = null;

                switch (menuItemId)  {
                    case R.id.action_book_popular:
                        selectedFragment = PopularBookFragment.newInstance();
                        break;

                    case R.id.action_book_review:
                        selectedFragment = ReviewFragment.newInstance();
                        break;

                    case R.id.action_book_readed:
                        selectedFragment = MyBookStoreFragment.newInstance();
                        break;

                    case R.id.action_book_rank:
                        selectedFragment = RankFragment.newInstance();
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
        transaction.replace(R.id.store_fragment_container, PopularBookFragment.newInstance());
        transaction.commit();
    }

}

package com.example.user.mil;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.mil.R;
import com.example.user.mil.view.book.BookActivity;
import com.example.user.mil.view.community.CommunityActivity;
import com.example.user.mil.view.store.StoreActivity;
import com.example.user.mil.view.troop.TroopActivity;
import com.ramotion.circlemenu.CircleMenuView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuSelectActivity extends AppCompatActivity {
//
    @OnClick(R.id.menu_select_market)
    public void moveToStore() {
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.menu_book_select)
    public void moveToBook() {
        Intent intent = new Intent(this, BookActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.menu_commmunity_select)
    public void moveToCommunity() {
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    };

    @OnClick(R.id.menu_troop_select)
    public void moveToTroop() {
        Intent intent = new Intent(this, TroopActivity.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_select);

        ButterKnife.bind(this);
    }

}

package com.example.user.mil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.mil.R;
import com.example.user.mil.view.book.BookActivity;
import com.example.user.mil.view.store.StoreActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuSelectActivity extends AppCompatActivity {



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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_select);

        ButterKnife.bind(this);
    }

}

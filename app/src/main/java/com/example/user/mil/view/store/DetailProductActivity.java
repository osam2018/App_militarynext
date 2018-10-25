package com.example.user.mil.view.store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.mil.R;
import com.example.user.mil.application.MilitaryNextApplication;
import com.example.user.mil.model.UsedProduct;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailProductActivity extends AppCompatActivity {

    @BindView(R.id.used_detail_imageview)
    ImageView detailImageView;

    @BindView(R.id.used_detail_title)
    TextView detailtitleView;

    @BindView(R.id.used_detail_price)
    TextView priceView;

    @BindView(R.id.used_detail_description)
    TextView descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        ButterKnife.bind(this);

        UsedProduct product = MilitaryNextApplication.getCurrentUsedProduct();
        Glide.with(getApplicationContext()).load(product.getImageLink()).into(detailImageView);
        detailtitleView.setText(product.getName());
        priceView.setText(String.valueOf(product.getPrice()) + "원");
        descriptionView.setText(product.getDescription());
    }
}

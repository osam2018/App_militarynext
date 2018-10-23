package com.example.user.mil.view.store;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.mil.R;
import com.example.user.mil.model.UsedProduct;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsedProductRecyclerViewAdapter extends RecyclerView.Adapter<UsedProductRecyclerViewAdapter.ViewHolder> {

    ArrayList mValues;
    Context mContext;

    public UsedProductRecyclerViewAdapter(Context context, ArrayList values) {
        mValues = values;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.used_product_image)
        ImageView imageUrl;

        @BindView(R.id.used_product_title)
        TextView title;

        @BindView(R.id.used_product_included)
        TextView included;

        @BindView(R.id.used_product_price)
        TextView price;

        @BindView(R.id.used_product_like_icon)
        ImageView likedIcon;

        @BindView(R.id.used_product_like_count)
        TextView likedCount;

        @BindView(R.id.used_product_see_count)
        TextView seeCount;

        protected UsedProduct item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void setData(UsedProduct item) {
            this.item = item;

            title.setText(item.getTile());
            included.setText(item.getUserIncluded());
            price.setText(String.valueOf(item.getPrice()));
            likedCount.setText(String.valueOf(item.getLikedCount()));
            seeCount.setText(String.valueOf(item.getSeeCount()));

        }

        @Override
        public void onClick(View v) {
            Log.d("OnClikcK", "으어");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_used_product, viewGroup, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.setData((UsedProduct)mValues.get(position));
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }
}

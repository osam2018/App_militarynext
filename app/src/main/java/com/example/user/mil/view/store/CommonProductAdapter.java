package com.example.user.mil.view.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.mil.R;
import com.example.user.mil.model.Book;
import com.example.user.mil.model.BookRank;
import com.example.user.mil.model.CommonProduct;

import java.util.ArrayList;

public class CommonProductAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CommonProduct> models;

    public CommonProductAdapter(Context context, ArrayList<CommonProduct> models ) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_book_rank, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CommonProduct model = models.get(position);

        Glide.with(context).load(model.getImageLink()).into(holder.productImageView);
        holder.brandTextView.setText(model.getBrand());
        holder.nameTextView.setText(model.getName());
        holder.saleTextView.setText(String.valueOf(model.getSalePercent()));
        holder.priceTextView.setText(String.valueOf(model.getPrice()));
        holder.buynumTextView.setText(String.valueOf(model.getBuyNum()));

        return convertView;
    }

    static class ViewHolder {

        ImageView productImageView;
        TextView brandTextView;
        TextView nameTextView;
        TextView saleTextView;
        TextView priceTextView;
        TextView buynumTextView;

        ViewHolder(View view) {
            productImageView = (ImageView) view.findViewById(R.id.custom_product_image);
            brandTextView = (TextView) view.findViewById(R.id.custom_product_brand);
            nameTextView = (TextView) view.findViewById(R.id.custom_product_name);
            saleTextView = (TextView) view.findViewById(R.id.custom_product_sale);
            priceTextView = (TextView) view.findViewById(R.id.custom_product_price);
            buynumTextView = (TextView) view.findViewById(R.id.custom_product_buyNum);
        }
    }
}

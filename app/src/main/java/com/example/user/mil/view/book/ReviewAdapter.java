package com.example.user.mil.view.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.user.mil.R;
import com.example.user.mil.model.BookRank;
import com.example.user.mil.model.Review;

import java.util.ArrayList;

public class ReviewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Review> models;

    public ReviewAdapter(Context context, ArrayList<Review> models ) {
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

            convertView = inflater.inflate(R.layout.card_review, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Review model = models.get(position);

        holder.nameTextView.setText(model.getBookName());
        holder.reviewTextView.setText(model.getDescription());
        holder.ratings.setRating(model.getStartRate());

        return convertView;
    }

    static class ViewHolder {
        TextView nameTextView;
        TextView reviewTextView;
        RatingBar ratings;

        ViewHolder(View view) {
            nameTextView = (TextView) view.findViewById(R.id.card_book_name);
            reviewTextView= (TextView) view.findViewById(R.id.card_book_review);
            ratings = (RatingBar) view.findViewById(R.id.card_book_rating);
        }
    }
}

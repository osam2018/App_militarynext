package com.example.user.mil.view.community;

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
import com.example.user.mil.model.Notice;
import com.example.user.mil.view.book.PopularBookAdapter;

import java.util.ArrayList;

public class NoticeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Notice> models;

    public NoticeAdapter(Context context, ArrayList<Notice> models ) {
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

            convertView = inflater.inflate(R.layout.card_notice, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Notice model = models.get(position);

        if(model != null) {
            holder.titleTextView.setText(model.getTitle());
//            Glide.with(context).load(model.getImageUrl()).into(holder.bookImageView);
//            holder.rankTextView.setText(String.valueOf(position + 1));
//            holder.nameTextView.setText(model.getName());
//            holder.authorTextView.setText(model.getAuthor());
//            holder.popularityTextView.setText(String.valueOf(model.getPopularity()));
        }

        return convertView;
    }

    static class ViewHolder {

        TextView titleTextView;
//        ImageView bookImageView;
//        TextView rankTextView;
//        TextView nameTextView;
//        TextView authorTextView;
//        TextView popularityTextView;

        ViewHolder(View view) {
//            bookImageView = (ImageView) view.findViewById(R.id.popular_book_image);
            titleTextView = (TextView) view.findViewById(R.id.noticeTextView);
//            nameTextView = (TextView) view.findViewById(R.id.popular_book_name);
//            authorTextView = (TextView) view.findViewById(R.id.popular_book_author);
//            popularityTextView = (TextView) view.findViewById(R.id.popular_book_popularity);
        }
    }
}

package com.example.user.mil.view.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.mil.R;
import com.example.user.mil.model.BookRank;

import java.util.ArrayList;

public class RankAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<BookRank> models;

    public RankAdapter(Context context, ArrayList<BookRank> models ) {
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

        BookRank model = models.get(position);

        holder.rank.setText(String.valueOf(position + 1));
        holder.name.setText(model.getUserName());
        holder.bookNum.setText(String.valueOf(model.getReadNum()));

        return convertView;
    }

    static class ViewHolder {
        TextView rank;
        TextView name;
        TextView bookNum;

        ViewHolder(View view) {
            rank = (TextView) view.findViewById(R.id.book_rank);
            name = (TextView) view.findViewById(R.id.book_rank_name);
            bookNum = (TextView) view.findViewById(R.id.book_rank_num);
        }
    }
}

package com.example.user.mil.view.book;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.user.mil.model.BookRank;

public class RankAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<BookRank> models;

    public  RankAdapter(Context context, ArrayList<BookRank> models ) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

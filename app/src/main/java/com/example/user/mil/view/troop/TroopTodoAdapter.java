package com.example.user.mil.view.troop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.mil.R;
import com.example.user.mil.model.TroopNotice;
import com.example.user.mil.model.TroopTodo;

import java.util.ArrayList;

public class TroopTodoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TroopTodo> models;

    public TroopTodoAdapter(Context context, ArrayList<TroopTodo> models) {
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

        TroopTodo model = models.get(position);

        if (model != null) {
            holder.titleTextView.setText(model.getTitle());
        }

        return convertView;
    }

    static class ViewHolder {

        TextView titleTextView;

        ViewHolder(View view) {
            titleTextView = (TextView) view.findViewById(R.id.noticeTextView);
        }
    }
}

package com.example.user.mil.view.troop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.mil.R;
import com.example.user.mil.model.TroopGroup;
import com.example.user.mil.model.TroopNotice;

import java.util.ArrayList;

public class TroopGroupAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TroopGroup> models;

    public TroopGroupAdapter(Context context, ArrayList<TroopGroup> models ) {
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

            convertView = inflater.inflate(R.layout.card_troop_group, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TroopGroup troopGroup = models.get(position);

        if(troopGroup != null) {
            holder.groupMaxTextView.setText("[ " + String.valueOf(troopGroup.getCurrentNum()) + " / " + String.valueOf(troopGroup.getMaxNum()) + "]");
            holder.groupNameTextView.setText(troopGroup.getGroupName());
            holder.groupOwnerTextView.setText(troopGroup.getGroupOwner());
            holder.groupContentTextView.setText(troopGroup.getGroupContent());
        }

        return convertView;
    }

    static class ViewHolder {

        TextView groupMaxTextView;
        TextView groupNameTextView;
        TextView groupOwnerTextView;
        TextView groupContentTextView;

        ViewHolder(View view) {
            groupMaxTextView  = (TextView) view.findViewById(R.id.group_max_textview);;
            groupNameTextView = (TextView) view.findViewById(R.id.group_name_textview);
            groupOwnerTextView = (TextView) view.findViewById(R.id.group_owner_textview);
            groupContentTextView = (TextView) view.findViewById(R.id.group_content_textview);
//            titleTextView = (TextView) view.findViewById(R.id.noticeTextView);
        }
    }
}
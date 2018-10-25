package com.example.user.mil.view.community;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.mil.R;
import com.example.user.mil.model.TimeLine;

import java.util.ArrayList;

public class TimeLineAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TimeLine> models;

    public TimeLineAdapter(Context context, ArrayList<TimeLine> models ) {
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

            convertView = inflater.inflate(R.layout.card_timeline, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TimeLine model = models.get(position);

        if(model != null) {
//            Glide.with(context).load(model.getImageUrl()).into(holder.bookImageView);
            holder.titleTextview.setText(model.getTitle());
            holder.descriptionTextView.setText(model.getDescription());
            holder.seeCountTextView.setText(model.getSeeNum());
            holder.reviewCountTextView.setText(String.valueOf(model.getReviewNum()));
        }

        return convertView;
    }

    static class ViewHolder {

        TextView titleTextview;
        TextView descriptionTextView;
        TextView seeCountTextView;
        TextView reviewCountTextView;

        ViewHolder(View view) {
            titleTextview = (TextView) view.findViewById(R.id.tileline_title);
            descriptionTextView = (TextView) view.findViewById(R.id.tileline_description);
            seeCountTextView = (TextView) view.findViewById(R.id.timeline_see_count);
            reviewCountTextView = (TextView) view.findViewById(R.id.timeline_review_count);
        }
    }
}

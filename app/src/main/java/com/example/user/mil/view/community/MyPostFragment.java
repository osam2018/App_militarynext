package com.example.user.mil.view.community;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.mil.R;
import com.example.user.mil.application.MilitaryNextApplication;
import com.example.user.mil.model.TimeLine;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyPostFragment extends Fragment {

    ArrayList<TimeLine> timeLineArrayList = new ArrayList<TimeLine>();
    TimeLineAdapter timeLineAdapter;
    private ListView timeLineListView;

    public MyPostFragment() {
        // Required empty public constructor
    }

    public static MyPostFragment newInstance() {
        MyPostFragment fragment = new MyPostFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_post, container, false);

        timeLineListView = (ListView) view.findViewById(R.id.timeline_listview);
        timeLineAdapter = new TimeLineAdapter(getContext(), timeLineArrayList);
        timeLineListView.setAdapter(timeLineAdapter);
        timeLineListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(timeLineArrayList.get(position).getWebUrl()));
//                startActivity(intent);
            }
        });

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        timeLineArrayList.clear();
        getTimeline();
    }

    public void getTimeline() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("timeline").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TimeLine timeLine = snapshot.getValue(TimeLine.class);
                    if(timeLine.getUserid().equals(MilitaryNextApplication.getCurrentUser().getMilNumber()))
                        timeLineArrayList.add(timeLine);
                }
                timeLineAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}

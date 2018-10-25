package com.example.user.mil.view.troop;

import android.content.Context;
import android.content.Intent;
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
import com.example.user.mil.model.Notice;
import com.example.user.mil.model.TroopNotice;
import com.example.user.mil.view.community.NoticeAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class TroopNoticeFragment extends Fragment {

    private ArrayList<TroopNotice> troopNotices = new ArrayList<TroopNotice>();
    private ListView troopNoticesListView;
    TroopNoticeAdapter troopNoticeAdapter;


    public TroopNoticeFragment() {
        // Required empty public constructor
    }


    public static TroopNoticeFragment newInstance() {
        TroopNoticeFragment fragment = new TroopNoticeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_troop_notice, container, false);
        troopNoticesListView = (ListView) view.findViewById(R.id.troop_notice_listview);
        troopNoticeAdapter = new TroopNoticeAdapter(getContext(), troopNotices);
        troopNoticesListView.setAdapter(troopNoticeAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        troopNotices.clear();
        getTroopNoticeData();
    }

    public void getTroopNoticeData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("troop").child("notice").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TroopNotice troopNotice = snapshot.getValue(TroopNotice.class);
                    troopNotices.add(troopNotice);
                }
                troopNoticeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}

package com.example.user.mil.view.troop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.mil.R;
import com.example.user.mil.model.TroopGroup;
import com.example.user.mil.model.TroopNotice;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class TroopGroupFragment extends Fragment {

    private ArrayList<TroopGroup> troopGroups = new ArrayList<TroopGroup>();
    private ListView troopGroupsListView;
    TroopGroupAdapter troopGroupAdapter;

    public TroopGroupFragment() {
        // Required empty public constructor
    }


    public static TroopGroupFragment newInstance() {
        TroopGroupFragment fragment = new TroopGroupFragment();

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
        View view = inflater.inflate(R.layout.fragment_troop_group, container, false);
        troopGroupsListView = (ListView) view.findViewById(R.id.troop_group_listview);
        troopGroupAdapter = new TroopGroupAdapter(getContext(), troopGroups);
        troopGroupsListView.setAdapter(troopGroupAdapter);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        troopGroups.clear();
        getTroopGroupData();
    }

    public void getTroopGroupData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("troop").child("group").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TroopGroup troopGroup = snapshot.getValue(TroopGroup.class);
                    troopGroups.add(troopGroup);
                }
                troopGroupAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}

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
import android.widget.CalendarView;
import android.widget.ListView;

import com.example.user.mil.R;
import com.example.user.mil.model.Notice;
import com.example.user.mil.model.TroopTodo;
import com.example.user.mil.view.community.NoticeAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;


public class TroopTodoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private ArrayList<TroopTodo> troopTodoArrayList = new ArrayList<TroopTodo>();
    private ListView troopTodoListView;
    TroopTodoAdapter troopTodoAdapter;

    public TroopTodoFragment() {
        // Required empty public constructor
    }

    public static TroopTodoFragment newInstance() {
        TroopTodoFragment fragment = new TroopTodoFragment();
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
        View view = inflater.inflate(R.layout.fragment_troop_todo, container, false);
        troopTodoListView = (ListView) view.findViewById(R.id.troop_todo_listview);
        troopTodoAdapter = new TroopTodoAdapter(getContext(), troopTodoArrayList);
        troopTodoListView.setAdapter(troopTodoAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        troopTodoArrayList.clear();
        getTroopTodoArrayList();
    }

    public void getTroopTodoArrayList() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH) + 1;
        final int day = calendar.get(calendar.DATE);

        databaseReference.child("troop").child("todo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TroopTodo troopTodo = snapshot.getValue(TroopTodo.class);

                    if(year == troopTodo.getYear() && month == troopTodo.getMonth() && day == troopTodo.getDay())
                        troopTodoArrayList.add(troopTodo);


                }
                troopTodoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}

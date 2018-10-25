package com.example.user.mil.view.troop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;

import com.example.user.mil.R;
import com.example.user.mil.model.Notice;
import com.example.user.mil.model.TroopTodo;
import com.example.user.mil.view.community.NoticeAdapter;

import java.util.ArrayList;


public class TroopTodoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private ArrayList<TroopTodo> noticeArrayList = new ArrayList<TroopTodo>();
    private ListView noticeListView;
    NoticeAdapter noticeAdapter;

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
        return inflater.inflate(R.layout.fragment_troop_todo, container, false);
    }


}

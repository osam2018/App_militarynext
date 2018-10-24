package com.example.user.mil.view.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mil.R;

public class SellFragment extends Fragment {

    public SellFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SellFragment newInstance() {
        SellFragment fragment = new SellFragment();
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

        return inflater.inflate(R.layout.fragment_sell, container, false);
    }

    @Override
    public void  onStart() {
        super.onStart();
    }



}

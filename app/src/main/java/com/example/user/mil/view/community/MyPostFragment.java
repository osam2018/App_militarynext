package com.example.user.mil.view.community;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mil.R;

public class MyPostFragment extends Fragment {

    public MyPostFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_post, container, false);
    }

}

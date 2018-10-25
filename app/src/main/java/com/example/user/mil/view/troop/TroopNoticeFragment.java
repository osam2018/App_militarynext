package com.example.user.mil.view.troop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mil.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TroopNoticeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TroopNoticeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TroopNoticeFragment extends Fragment {


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
        return inflater.inflate(R.layout.fragment_troop_notice, container, false);
    }


}

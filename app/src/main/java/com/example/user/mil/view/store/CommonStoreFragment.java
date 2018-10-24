package com.example.user.mil.view.store;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.mil.R;

import butterknife.BindView;
import butterknife.ButterKnife;



public class CommonStoreFragment extends Fragment {

    @BindView(R.id.custom_product_listview)
    ListView customStoreRecyclerview;


    public CommonStoreFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CommonStoreFragment newInstance() {
        CommonStoreFragment fragment = new CommonStoreFragment();

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

        View view = inflater.inflate(R.layout.fragment_common_shop, container, false);
        ButterKnife.bind(this, view);

        return view;

    }


}

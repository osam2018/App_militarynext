package com.example.user.mil.view.book;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mil.R;


public class PopularBookFragment extends Fragment {

    public PopularBookFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PopularBookFragment newInstance() {
        PopularBookFragment fragment = new PopularBookFragment();
        return fragment;

        //http://www.ypbooks.co.kr/ypbooks/book/kor/requestAjax.jsp?sMode=mdrecomm



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_book, container, false);
    }


}

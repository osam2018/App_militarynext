package com.example.user.mil.view.book;

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
import com.example.user.mil.model.BookRank;
import com.example.user.mil.model.Review;
import com.example.user.mil.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class ReviewFragment extends Fragment {

    private ArrayList<Review> reviewArrayList = new ArrayList<Review>();
    private ListView reviewListView;
    ReviewAdapter reviewAdapter;

    public ReviewFragment() {
        // Required empty public constructor
    }


    public static ReviewFragment newInstance() {
        ReviewFragment fragment = new ReviewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_review, container, false);
        reviewListView = (ListView) view.findViewById(R.id.book_review_listview);
        reviewAdapter = new ReviewAdapter(getContext(), reviewArrayList);
        reviewListView.setAdapter(reviewAdapter);

        // Inflate the layout for this fragment
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        getRaviewData();
    }

    public void getRaviewData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("reviews").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Review review = snapshot.getValue(Review.class);
                    reviewArrayList.add(review);
                }
                reviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}

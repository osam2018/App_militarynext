package com.example.user.mil.view.book;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.mil.R;
import com.example.user.mil.model.BookRank;
import com.example.user.mil.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RankFragment extends Fragment {

    private ArrayList<BookRank> bookRankArrayList = new ArrayList<BookRank>();
    private ListView bookListView;
    RankAdapter rankAdapter;

    public RankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RankFragment newInstance() {
        RankFragment fragment = new RankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        bookListView = (ListView) view.findViewById(R.id.book_rank_listview);
        rankAdapter = new RankAdapter(getContext(), bookRankArrayList);
        bookListView.setAdapter(rankAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onStart() {
       super.onStart();
        bookRankArrayList.clear();
        getRankingData();
    }

    public void getRankingData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("user").orderByChild("bookNum").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);
                    BookRank newBookRank = new BookRank(user.getTroopName() + " " + user.getGrade() + " " + user.getName(), user.getBookNum());
                    bookRankArrayList.add(newBookRank);
                }
                rankAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}

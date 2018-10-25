package com.example.user.mil.view.book;

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
import android.widget.ListView;

import com.example.user.mil.R;
import com.example.user.mil.model.Book;
import com.example.user.mil.model.BookRank;
import com.example.user.mil.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class PopularBookFragment extends Fragment {

    ArrayList<Book> bookArrayList = new ArrayList<Book>();
    PopularBookAdapter popularBookAdapter;
    private ListView popularBookListView;

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

        View view = inflater.inflate(R.layout.fragment_popular_book, container, false);
        popularBookListView = (ListView) view.findViewById(R.id.popularbook_listview);
        popularBookAdapter = new PopularBookAdapter(getContext(), bookArrayList);
        popularBookListView.setAdapter(popularBookAdapter);
        popularBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(bookArrayList.get(position).getWebUrl()));
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        bookArrayList.clear();
        getRankingData();
    }

    public void getRankingData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("books").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Book book = snapshot.getValue(Book.class);
                    bookArrayList.add(book);
                }
                popularBookAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}

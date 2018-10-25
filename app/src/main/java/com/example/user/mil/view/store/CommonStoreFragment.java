package com.example.user.mil.view.store;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.mil.R;
import com.example.user.mil.model.Book;
import com.example.user.mil.model.CommonProduct;
import com.example.user.mil.view.book.PopularBookAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class CommonStoreFragment extends Fragment {

    @BindView(R.id.custom_product_listview)
    ListView customStoreRecyclerview;

    ArrayList<CommonProduct> commonProducts = new ArrayList<CommonProduct>();
    CommonProductAdapter commonProductAdapter;
    private ListView commonProductListView;


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
        ButterKnife.bind(this,view);

        commonProductListView = (ListView) view.findViewById(R.id.custom_product_listview);
        commonProductAdapter = new CommonProductAdapter(getContext(), commonProducts);
        commonProductListView.setAdapter(commonProductAdapter);
        commonProductListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(commonProducts.get(position).getWebLink()));
                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getCommonProductsData();
    }

    public void getCommonProductsData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("store").child("common").child("items").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    CommonProduct commonProduct = snapshot.getValue(CommonProduct.class);
                    commonProducts.add(commonProduct);
                }
                commonProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}

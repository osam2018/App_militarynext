package com.example.user.mil.view.store;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.mil.R;
import com.example.user.mil.model.UsedProduct;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UsedProductFragment extends Fragment {


    @BindView(R.id.used_product_recycler)
    RecyclerView usedProductRecycler;

    private UsedProductRecyclerViewAdapter usedProductAdapter;
    private RecyclerView.LayoutManager usedProductLayoutManager;
    private ArrayList<UsedProduct> usedProducts = new ArrayList<UsedProduct>();

    public void initRecyclerView() {

        usedProductAdapter = new UsedProductRecyclerViewAdapter(getContext(), usedProducts);
        usedProductRecycler.setAdapter(usedProductAdapter);

        usedProductLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        usedProductRecycler.setLayoutManager(usedProductLayoutManager);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = firebaseDatabase.getReference();

        Toast.makeText(getContext(), String.valueOf(mDatabase.child("store").child("used").child("items")),Toast.LENGTH_SHORT).show();
        mDatabase.child("store").child("used").child("items").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot data : dataSnapshot.getChildren()) {
                    UsedProduct usedProduct = (UsedProduct)data.getValue(UsedProduct.class);
                    usedProducts.add(usedProduct);
                }
                usedProductAdapter.notifyDataSetChanged();
                Log.d("으악","이이");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public UsedProductFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static UsedProductFragment newInstance() {
        UsedProductFragment fragment = new UsedProductFragment();
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

        View view = inflater.inflate(R.layout.fragment_used_product, container, false);
        ButterKnife.bind(this, view);

        usedProductRecycler = (RecyclerView) view.findViewById(R.id.used_product_recycler);
        initRecyclerView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }



}

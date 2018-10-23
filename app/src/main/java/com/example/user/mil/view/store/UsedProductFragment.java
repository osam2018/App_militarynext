package com.example.user.mil.view.store;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mil.R;
import com.example.user.mil.model.UsedProduct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UsedProductFragment extends Fragment {


    @BindView(R.id.used_product_recycler)
    RecyclerView usedProductRecycler;

    private RecyclerView.Adapter usedProductAdapter;
    private RecyclerView.LayoutManager usedProductLayoutManager;
    private List<UsedProduct> usedProducts = new ArrayList<>();

    public void initRecyclerView() {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new UsedProduct("제목임",15000,"운동기구","https://cdn-images-1.medium.com/max/800/1*M6HU7jlyQhmV8CjFcKdQhw.png",13,12,"zz","ss", "zz"));
        arrayList.add(new UsedProduct("제목임",15000,"운동기구","https://cdn-images-1.medium.com/max/800/1*M6HU7jlyQhmV8CjFcKdQhw.png",13,12,"zz","ss", "zz"));
        arrayList.add(new UsedProduct("제목임",15000,"운동기구","https://cdn-images-1.medium.com/max/800/1*M6HU7jlyQhmV8CjFcKdQhw.png",13,12,"zz","ss", "zz"));
        arrayList.add(new UsedProduct("제목임",15000,"운동기구","https://cdn-images-1.medium.com/max/800/1*M6HU7jlyQhmV8CjFcKdQhw.png",13,12,"zz","ss", "zz"));
        arrayList.add(new UsedProduct("제목임",15000,"운동기구","https://cdn-images-1.medium.com/max/800/1*M6HU7jlyQhmV8CjFcKdQhw.png",13,12,"zz","ss", "zz"));

        UsedProductRecyclerViewAdapter adapter = new UsedProductRecyclerViewAdapter(getContext(), arrayList);
        usedProductRecycler.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        usedProductRecycler.setLayoutManager(manager);

//        usedProductLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        usedProductAdapter = new LinearLayoutManager(usedProducts);

//        usedProductRecycler.setAdapter(usedProductAdapter);
//        usedProductRecycler.setLayoutManager(usedProductLayoutManager);
    }

    public void loadUsedProductItems() {

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

        initRecyclerView();

        return view;
    }



}

package com.example.user.mil.view.store;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UsedProductFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UsedProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsedProductFragment extends Fragment {


    @BindView(R.id.used_product_recycler)
    RecyclerView usedProductRecycler;

    private RecyclerView.Adapter usedProductAdapter;
    private RecyclerView.LayoutManager usedProductLayoutManager;
    private List<UsedProduct> usedProducts = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

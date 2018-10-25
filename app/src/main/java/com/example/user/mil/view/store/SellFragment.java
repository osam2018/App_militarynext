package com.example.user.mil.view.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.mil.R;
import com.example.user.mil.application.MilitaryNextApplication;
import com.example.user.mil.model.UsedProduct;
import com.example.user.mil.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SellFragment extends Fragment {

    @BindView(R.id.sellProductNameEditText)
    EditText productName;

    @BindView(R.id.sellProductDetailEditText)
    EditText productDescription;

    @BindView(R.id.sellProductPriceEdittext)
    EditText productPrice;

   @OnClick(R.id.sellProductRegistButton)
   public void uploadProduct() {
       String name = productName.getText().toString();
       String description = productDescription.getText().toString();
       int price = Integer.parseInt(productPrice.getText().toString());

       User current = MilitaryNextApplication.getCurrentUser();

       if(name.length() == 0 )   {
           return;
       }

       FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
       DatabaseReference databaseReference = firebaseDatabase.getReference().child("store").child("used").child("items");

       String key = databaseReference.push().getKey();
       UsedProduct newUsedProduct = new UsedProduct(key, name,"", description,price,0,0,current.getMilNumber());

       databaseReference.child(key).setValue(newUsedProduct);

       Toast.makeText(getActivity(), "물품 업로드가 완료되었습니다.", Toast.LENGTH_SHORT).show();
   }

    public SellFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SellFragment newInstance() {
        SellFragment fragment = new SellFragment();
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

        View view = inflater.inflate(R.layout.fragment_sell, container, false);
        ButterKnife.bind(this,view);

        return view;
    }


    @Override
    public void  onStart() {
        super.onStart();
    }



}

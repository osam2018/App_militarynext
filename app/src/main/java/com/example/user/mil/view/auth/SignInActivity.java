package com.example.user.mil.view.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.mil.R;
import com.example.user.mil.model.User;
import com.example.user.mil.view.store.StoreActivity;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.loginIdTextView)
    EditText milNumberText;

    @BindView(R.id.loginPasswordTextView)
    EditText passwordText;

    @OnClick(R.id.loginIdPasswrodSubmitButton)
    public void onClickLogin() {
        signin();
    }

    @OnClick(R.id.loginRegisterButton)
    public void moveToSignUpPage() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ButterKnife.bind(this);
    }

    public void signin() {

        final String milNumber5 = milNumberText.getText().toString();
        final String password = passwordText.getText().toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference.child(milNumber5).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User user = dataSnapshot.getValue(User.class);
                if(user.getPassword().equals(password)) {
                    Intent intent = new Intent(SignInActivity.this, StoreActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(),"비밀번호가 틀렸습니다.", Toast.LENGTH_LONG );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"해당 군번으로 가입된 계정이 존재하지 않습니다.", Toast.LENGTH_LONG );
            }
        });
    }



    @VisibleForTesting
    public ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }









}

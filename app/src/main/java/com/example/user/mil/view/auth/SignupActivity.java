package com.example.user.mil.view.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.mil.R;
import com.example.user.mil.application.MilitaryNextApplication;
import com.example.user.mil.model.User;
import com.example.user.mil.view.store.StoreActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.signupIdTextView)
    EditText milNumberEditText;

    @BindView(R.id.signupNameTextView)
    EditText nameEditText;

    @BindView(R.id.signupPasswordTextView)
    EditText signupPasswordEditText;

    @BindView(R.id.signupPasswordRepeatTextView)
    EditText signupPasswordRepeatEditText;

    @BindView(R.id.signupgradeTextView)
    EditText signupgradeEditText;

    @BindView(R.id.signupTroopTextView)
    EditText signupTroopEditText;

    @OnClick(R.id.signupNextButton)
    public void onClickSignUp() {
        signup();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);
    }

    public void signup() {

        final String milNumber = milNumberEditText.getText().toString();
        final String name = nameEditText.getText().toString();
        final String passwoprd = signupPasswordEditText.getText().toString();
        String repeatPsssword = signupPasswordRepeatEditText.getText().toString();
        final String grade = signupgradeEditText.getText().toString();
        final String troop = signupTroopEditText.getText().toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference();

        if(milNumber.length() == 0) {
            Toast.makeText(getApplicationContext(), "군번을 입력해주세요",Toast.LENGTH_SHORT).show();
            return ;
        }
        if(name.length() == 0) {
            Toast.makeText(getApplicationContext(), "이름을 입력해주세요",Toast.LENGTH_SHORT).show();
            return ;
        }
        if(passwoprd.length() == 0) {
            Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요",Toast.LENGTH_SHORT).show();
            return ;
        }
        if(repeatPsssword.length() == 0) {
            Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요",Toast.LENGTH_SHORT).show();
            return ;
        }
        if(grade.length() == 0) {
            Toast.makeText(getApplicationContext(), "계끕을 입력해주세요",Toast.LENGTH_SHORT).show();
            return ;
        }
        if(troop.length() == 0) {
            Toast.makeText(getApplicationContext(), "부대명을 입력해주세요",Toast.LENGTH_SHORT).show();
            return ;
        }

        if(!passwoprd.equals(repeatPsssword)) {
            Toast.makeText(getApplicationContext(), "패스워드가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
            return ;
        }

        databaseReference.child("user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChild(milNumber))  {
                    Toast.makeText(getApplicationContext(), "이미 존재하는 회원입니다",Toast.LENGTH_SHORT).show();
                    return ;
                }

                User newUser = new User(milNumber,passwoprd,name,grade,troop,0);
                databaseReference.child("user").child(milNumber).setValue(newUser);
                MilitaryNextApplication.setCurrentUser(newUser);

                Intent intent = new Intent(getApplicationContext(), StoreActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "인터넷 연결을 확인해주세요",Toast.LENGTH_SHORT).show();
                return ;
            }
        });



    }


}

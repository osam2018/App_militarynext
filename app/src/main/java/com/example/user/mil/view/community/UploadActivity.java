package com.example.user.mil.view.community;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.mil.R;
import com.example.user.mil.application.MilitaryNextApplication;
import com.example.user.mil.model.TimeLine;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadActivity extends AppCompatActivity {

    @BindView(R.id.timelineNameEditText)
    EditText titleEditText;

    @BindView(R.id.timelineDetailEditText)
    EditText descriptionEditText;


    @OnClick(R.id.addtimelineCompleteButton)
    public void uploadTimeline() {
        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("timeline");
        String key = databaseReference.push().getKey();
        TimeLine timeLine = new TimeLine(key, title,description,MilitaryNextApplication.getCurrentUser().getMilNumber(),0,0);
        databaseReference.child(key).setValue(timeLine).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "게시글 등록이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        ButterKnife.bind(this);
    }





}

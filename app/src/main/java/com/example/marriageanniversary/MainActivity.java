package com.example.marriageanniversary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView points;
    String changedPoints = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView galleryBtn = findViewById(R.id.galleryBtn);
        TextView questionsBtn = findViewById(R.id.questionnaireBtn);
        points = findViewById(R.id.points);


        galleryBtn.setOnClickListener(this);
        questionsBtn.setOnClickListener(this);
        points.setOnClickListener(this);

        FirebaseDatabase.getInstance().getReference().child("She")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                points.setText(dataSnapshot.getValue().toString());
                changedPoints = dataSnapshot.getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onClick( View v ) {

        switch (v.getId()) {

            case R.id.galleryBtn:
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
                break;

            case R.id.questionnaireBtn:
                Intent intent1 = new Intent(MainActivity.this, QuestionnaireActivity.class);
                startActivity(intent1);
                break;

            case R.id.backBtn:
                finish();
                break;

            case R.id.points:
                Intent intent2 = new Intent(MainActivity.this, PointsActivity.class);
                intent2.putExtra("points", changedPoints);
                startActivity(intent2);
                break;
        }
    }
}

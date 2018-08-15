package com.example.marriageanniversary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pointsactivity);

        TextView pointsTV = findViewById(R.id.pointsTV);
        String points = getIntent().getStringExtra("points");
        if (points.contentEquals("0")) {
            pointsTV.setText("Please ask your partner to answer the questionnaire");
        } else {
            pointsTV.setText("Hurrayyyy!!! You have been given " + points + " points by your partner");
        }


        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

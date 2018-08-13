package com.example.marriageanniversary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView galleryBtn = findViewById(R.id.galleryBtn);
        TextView questionsBtn = findViewById(R.id.questionnaireBtn);

        galleryBtn.setOnClickListener(this);
        questionsBtn.setOnClickListener(this);


    }

    @Override
    public void onClick( View v ) {

        switch (v.getId()) {

            case R.id.galleryBtn:
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
                break;

            case R.id.questionnaireBtn:
                Intent intent1 = new Intent(MainActivity.this, QuestionnaireActivity.class);
                startActivity(intent1);
                break;

            case R.id.backBtn:
                finish();

        }
    }
}

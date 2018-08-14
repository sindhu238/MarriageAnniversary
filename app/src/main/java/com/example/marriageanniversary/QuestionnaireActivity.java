package com.example.marriageanniversary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by srisindhu.pydimukkal on 13/08/2018.
 */

public class QuestionnaireActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout questionnaireLyout;
    TextView nextTV;
    LinearLayout queryLayout;
    boolean isQuestionsPresented = false;
    Guideline guideline;
    TextView points;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.questionnaire_activity);
        questionnaireLyout = findViewById(R.id.quesLayout);
        queryLayout = findViewById(R.id.queriesLayout);
        nextTV = findViewById(R.id.getStartedTV);
        guideline = findViewById(R.id.guideline2);
        points = findViewById(R.id.points);

        ImageView backBtn = findViewById(R.id.backBtn);
        nextTV.setOnClickListener(this);
        backBtn.setOnClickListener(this);


    }

    @Override
    public void onClick( View v ) {
        switch (v.getId()) {

            case R.id.getStartedTV:

                final AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
                alphaAnimation.setDuration(400);

                if (!isQuestionsPresented) {
                    questionnaireLyout.startAnimation(alphaAnimation);
                    isQuestionsPresented = true;
                } else {
                    queryLayout.startAnimation(alphaAnimation);
                }

                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        questionnaireLyout.setVisibility(View.GONE);

                        final AlphaAnimation alphaAnimation1 = new AlphaAnimation(0f, 1f);
                        alphaAnimation1.setDuration(300);
                        queryLayout.startAnimation(alphaAnimation1);


                        alphaAnimation1.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                queryLayout.setAlpha(1);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        nextTV.setText("Next");

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                break;

            case R.id.backBtn:
                finish();
                break;
         }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                int count = Integer.valueOf(points.getText().toString());

                if (x < guideline.getX()) {
                    if (count != 0)
                        count -= 1;
                } else {
                    if (count != 10)
                        count += 1;
                }
                points.setText(String .valueOf(count));
                break;

                default:
                    break;
        }



        return super.onTouchEvent(event);
    }
}

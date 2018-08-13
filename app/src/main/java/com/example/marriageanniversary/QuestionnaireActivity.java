package com.example.marriageanniversary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by srisindhu.pydimukkal on 13/08/2018.
 */

public class QuestionnaireActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.questionnaire_activity);

    }

    @Override
    public void onClick( View v ) {
        switch (v.getId()) {

            case R.id.getStartedTV:

                break;
         }
    }


}

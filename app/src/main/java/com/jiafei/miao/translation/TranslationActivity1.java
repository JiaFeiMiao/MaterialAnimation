package com.jiafei.miao.translation;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;

import com.jiafei.miao.R;
import com.jiafei.miao.contants.Contant;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zouyingjie on 16/3/10.
 */
public class TranslationActivity1 extends AppCompatActivity{

    private String type;
    @InjectView(R.id.btnExit)Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = (String) getIntent().getCharSequenceExtra(Contant.TRAN_TAG);
        setTranslation();
        setContentView(R.layout.activity_translation1);
        ButterKnife.inject(this);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setTranslation(){
        Transition transition = null;
        switch (type){
            case Contant.TRAN_BY_JAVA:
                transition = new Explode();
                transition.setDuration(1000);
                transition.setInterpolator(new AnticipateInterpolator());
                break;
            case Contant.TRAN_BY_XML:
                transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                break;
        }
        getWindow().setEnterTransition(transition);

        getWindow().setExitTransition(new Explode());
    }
}

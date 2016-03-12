package com.jiafei.miao.translation;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jiafei.miao.R;
import com.jiafei.miao.contants.Contant;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by zouyingjie on 16/3/10.
 */
public class TranslationActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TRAN_TAG = "tranTag";
    @InjectView(R.id.btnTranExplode1)Button btnTranExplode1;
    @InjectView(R.id.btnTranExplode2)Button btnTranExplode2;
    @InjectView(R.id.btnTranFade1)Button btnTranFade1;
    @InjectView(R.id.btnTranFade2)Button btnTranFade2;
    @InjectView(R.id.btnTranSlide1)Button btnTranSlide1;
    @InjectView(R.id.btnTranSlide2)Button btnTranSlide2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        ButterKnife.inject(this);

        btnTranExplode1.setOnClickListener(this);
        btnTranExplode2.setOnClickListener(this);
        btnTranFade1.setOnClickListener(this);
        btnTranFade2.setOnClickListener(this);
        btnTranSlide1.setOnClickListener(this);
        btnTranSlide2.setOnClickListener(this);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.btnTranExplode1:
                Intent intent = new Intent(this, TranslationActivity1.class);
                intent.putExtra(Contant.TRAN_TAG, Contant.TRAN_BY_JAVA);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btnTranExplode2:
                Intent intent2 = new Intent(this, TranslationActivity1.class);
                intent2.putExtra(Contant.TRAN_TAG, Contant.TRAN_BY_XML);
                startActivity(intent2, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btnTranFade1:
                Intent intent3 = new Intent(this, TranslationActivity2.class);
                intent3.putExtra(Contant.TRAN_TAG, Contant.TRAN_BY_JAVA);
                startActivity(intent3, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btnTranFade2:
                Intent intent4 = new Intent(this, TranslationActivity2.class);
                intent4.putExtra(Contant.TRAN_TAG, Contant.TRAN_BY_XML);
                startActivity(intent4, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btnTranSlide1:
                Intent intent5 = new Intent(this, TranslationActivity3.class);
                intent5.putExtra(Contant.TRAN_TAG, Contant.TRAN_BY_JAVA);
                startActivity(intent5, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btnTranSlide2:
                Intent intent6 = new Intent(this, TranslationActivity3.class);
                intent6.putExtra(Contant.TRAN_TAG, Contant.TRAN_BY_XML);
                startActivity(intent6, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            default:
                break;
        }


    }
}

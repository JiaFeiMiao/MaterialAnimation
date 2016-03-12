package com.jiafei.miao.demo2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jiafei.miao.R;

/**
 * Created by zouyingjie on 16/3/8.
 */
public class RevalActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout viewRoot;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(TRANSL)
        setContentView(R.layout.activity_reval);
        setEnterAndExitTranslation();
        viewRoot = (RelativeLayout) findViewById(R.id.viewRoot);
        iv1 = (ImageView) findViewById(R.id.ivImage1);
        iv2 = (ImageView) findViewById(R.id.ivImage2);
        iv3 = (ImageView) findViewById(R.id.ivImage3);
        iv4 = (ImageView) findViewById(R.id.ivImage4);

        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
    }

    private void setEnterAndExitTranslation(){
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ivImage1:
                Animator anim1 = ViewAnimationUtils.createCircularReveal(viewRoot, 0, 0, 0, viewRoot.getHeight() / 2);
                anim1.setDuration(500);
                anim1.setInterpolator(new AccelerateInterpolator());
                viewRoot.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                anim1.start();

                break;
            case R.id.ivImage2:
                Animator anim2 = ViewAnimationUtils.createCircularReveal(viewRoot, viewRoot.getRight(), 0, 0, viewRoot.getHeight() / 2);
                anim2.setDuration(500);
                anim2.setInterpolator(new AccelerateInterpolator());
                viewRoot.setBackgroundColor(Color.parseColor("#00ffff"));
                anim2.start();
                break;
            case R.id.ivImage3:
                final int x = (viewRoot.getLeft() + viewRoot.getRight()) / 2;
                final int y = (viewRoot.getTop() + viewRoot.getBottom()) / 2;
                final int rx = (iv3.getLeft() + iv3.getRight()) / 2;
                final int ry = (iv3.getTop() + iv3.getBottom()) / 2;
                final ViewGroup.LayoutParams layoutParams = iv3.getLayoutParams();
                ObjectAnimator tX = ObjectAnimator.ofFloat(iv3, "translationX", 0, x - rx);
                ObjectAnimator tY = ObjectAnimator.ofFloat(iv3, "translationY", 0, -y);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(500);
                set.setInterpolator(new LinearInterpolator());
                set.playTogether(tX, tY);
                set.start();

                set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        iv3.setLayoutParams(layoutParams);
                        iv3.setVisibility(View.INVISIBLE);

                        Animator anim3 = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0, viewRoot.getWidth() / 2);
                        anim3.setDuration(500);
                        anim3.setInterpolator(new AccelerateInterpolator());
                        viewRoot.setBackground(getResources().getDrawable(R.drawable.vector_heart));
                        anim3.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

                break;
            case R.id.ivImage4:
                break;
        }
    }
}

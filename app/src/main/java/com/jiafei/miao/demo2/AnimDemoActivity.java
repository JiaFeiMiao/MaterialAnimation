package com.jiafei.miao.demo2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.jiafei.miao.R;

/**
 * Created by zouyingjie on 16/3/6.
 */
public class AnimDemoActivity extends AppCompatActivity {

    private View view1;
    private View view2;
    private View view3;
    private View view4;
    private View view5;

    private boolean open = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view5 = findViewById(R.id.view5);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (open) {
                    ObjectAnimator anim01 = ObjectAnimator.ofFloat(view2, "translationX", 0, 180);
                    ObjectAnimator anim02 = ObjectAnimator.ofFloat(view3, "translationX", 0, -180);
                    ObjectAnimator anim03 = ObjectAnimator.ofFloat(view4, "translationY", 0, 180);
                    ObjectAnimator anim04 = ObjectAnimator.ofFloat(view5, "translationY", 0, -180);

                    AnimatorSet set = new AnimatorSet();
                    set.setDuration(200);
                    set.setInterpolator(new AccelerateInterpolator());
                    set.playTogether(anim01, anim02, anim03, anim04);
                    set.start();
                    open = false;
                } else {
                    ObjectAnimator anim01 = ObjectAnimator.ofFloat(view2, "translationX", 180, 0);
                    ObjectAnimator anim02 = ObjectAnimator.ofFloat(view3, "translationX", -180, 0);
                    ObjectAnimator anim03 = ObjectAnimator.ofFloat(view4, "translationY", 180, 0);
                    ObjectAnimator anim04 = ObjectAnimator.ofFloat(view5, "translationY", -180, 0);

                    AnimatorSet set = new AnimatorSet();
                    set.setDuration(200);
                    set.setInterpolator(new AccelerateInterpolator());
                    set.playTogether(anim01, anim02, anim03, anim04);
                    set.start();
                    open = true;
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!open) {
                    //闪烁
                    ObjectAnimator anim01 = ObjectAnimator.ofFloat(view2, "alpha", 0, 50, 100, 0, 50, 100, 0, 50, 100);
                    ObjectAnimator anim02 = ObjectAnimator.ofFloat(view3, "alpha", 0, 50, 100, 0, 50, 100, 0, 50, 100);
                    ObjectAnimator anim03 = ObjectAnimator.ofFloat(view4, "alpha", 0, 50, 100, 0, 50, 100, 0, 50, 100);
                    ObjectAnimator anim04 = ObjectAnimator.ofFloat(view5, "alpha", 0, 50, 100, 0, 50, 100, 0, 50, 100);

                    AnimatorSet set = new AnimatorSet();
                    set.setDuration(2000);
                    set.setInterpolator(new LinearInterpolator());
                    set.playTogether(anim01, anim02, anim03, anim04);
                    set.start();
                } else {
                    //抛物线
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setDuration(3000);
                    valueAnimator.setObjectValues(new PointF(0, 0));
                    valueAnimator.setInterpolator(new LinearInterpolator());
                    valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
                        // fraction = t / duration
                        @Override
                        public PointF evaluate(float fraction, PointF startValue,
                                               PointF endValue) {
                            // x方向200px/s ，则y方向0.5 * 10 * t
                            PointF point = new PointF();
                            point.x = 200 * fraction * 3;
                            point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                            return point;
                        }
                    });

                    valueAnimator.start();
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            PointF point = (PointF) animation.getAnimatedValue();
                            view1.setX(point.x);
                            view1.setY(point.y);

                        }
                    });
//                    ObjectAnimator anim01 = ObjectAnimator.ofFloat(view2, "rotation", 90);
//                    ObjectAnimator anim02 = ObjectAnimator.ofFloat(view3, "rotation", 90);
//                    ObjectAnimator anim03 = ObjectAnimator.ofFloat(view4, "rotation", 90);
//                    ObjectAnimator anim04 = ObjectAnimator.ofFloat(view5, "rotation", 90);
//                    AnimatorSet set = new AnimatorSet();
//                    set.setDuration(200);
//
//                    set.setInterpolator(new AccelerateInterpolator());
//                    set.playTogether(anim01, anim02, anim03, anim04);
//                    set.start();

                }
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}

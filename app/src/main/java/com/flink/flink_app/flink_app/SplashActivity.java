package com.flink.flink_app.flink_app;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.flink.flink_app.flink_app.font.RobotoTextView;
import com.flink.flink_app.flink_app.views.KenBurnsView;

public class SplashActivity extends Activity {

    private KenBurnsView kBurns;
    private ImageView fLogo;
    private RobotoTextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        kBurns = (KenBurnsView) findViewById(R.id.ken_burns_images);
        fLogo = (ImageView) findViewById(R.id.logo);
        welcomeText= (RobotoTextView) findViewById(R.id.welcome_text);
        kBurns.setImageResource(R.drawable.splashimage);
        animation2();// Animacion Logo
        animation3();//Animacion Texto

        //Animation(); Animacion solo para logo


        // Se crea un Hilo para  dejar el Splash  5 segundos
        Thread timerThread = new Thread(){

            @Override
            public void run() {
                super.run();
                try{
                    sleep(5000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent= new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

    }
    // Varias animaciones
    private void Animation(){

        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(fLogo, "scaleX", 5.0F, 1.0F);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(1200);
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(fLogo, "scaleY", 5.0F, 1.0F);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(1200);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(fLogo, "alpha", 0.0F, 1.0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(1200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
        animatorSet.setStartDelay(500);
        animatorSet.start();
    }


    private void animation2() {
        fLogo.setAlpha(1.0F);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
        fLogo.startAnimation(anim);
    }

    private void animation3() {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(welcomeText, "alpha", 0.0F, 1.0F);
        alphaAnimation.setStartDelay(1700);
        alphaAnimation.setDuration(500);
        alphaAnimation.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}

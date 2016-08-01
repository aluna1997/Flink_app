package com.flink.flink_app.flink_app;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.flink.flink_app.flink_app.componets.DialogEmail;
import com.flink.flink_app.flink_app.util.VolleyCallBack;
import com.flink.flink_app.flink_app.util.VolleyRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class SplashActivity extends Activity {

    //Codigo de Login de Flink
    private ImageView fLogo;
    private EditText tUser;
    private EditText tPass;
    private Button  bSesion;
    private Button bAyuda;
    private Button bFlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        fLogo = (ImageView) findViewById(R.id.logo);
        tUser = (EditText) findViewById(R.id.user);
        tPass = (EditText) findViewById(R.id.password);
        bSesion = (Button) findViewById(R.id.session);
        bAyuda = (Button)findViewById(R.id.ayuda);
        bFlink = (Button)findViewById(R.id.flink_button);

        tUser.setAlpha(0.0F);
        tPass.setAlpha(0.0F);
        bSesion.setAlpha(0.0F);

        //TODO animation help an create account

        bSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*String user = tUser.getText().toString();
                String pass = tPass.getText().toString();
                JSONObject data = new JSONObject();

                try {
                    data.put("username",user);
                    data.put("password",pass);
                    //Toast  t = Toast.makeText(SplashActivity.this,data.toString(),Toast.LENGTH_LONG);
                    //t.show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                VolleyRequest vr = new VolleyRequest(SplashActivity.this,"http://173.255.115.106/auth-token/",data);
                vr.postLoginRequest(new VolleyCallBack() {
                    @Override
                    public void onSuccess(JSONObject data)  {
                      String  cs = new String();
                        try {
                            //cs = "  Token: " + data.getString("token") +"\n"+"cuenta: "+ data.getString("cuenta");
                            SharedPreferences sp = SplashActivity.this.getPreferences(Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("token",data.getString("token"));
                            editor.putString("cuenta", data.getString("cuenta"));
                            editor.commit();

*/
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                      /*  } catch (JSONException e) {
                            e.printStackTrace();
                        }*/


                    /*}

                    @Override
                    public void customOnSuccess(JSONObject string) {

                    }

                    @Override
                    public void onSuccess(int status) {

                    }
                });



            }*/
            }
        });


        bAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DialogEmail dialogEmail = new DialogEmail();
                dialogEmail.show(manager, "DialogEmail");
            }
        });

        bFlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.miflink.com"));
                startActivity(i);
            }
        });

        animation1();// Animacion Logo
        animation2();//Animacion Texto
        animation3();

        //Animation(); Animacion solo para logo


        // Se crea un Hilo para  dejar el Splash  5 segundos


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

        animatorSet.start();
    }


    /*private void animation2() {
        fLogo.setAlpha(1.0F);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
        fLogo.startAnimation(anim);
    }*/

    private  void animation1(){
        ObjectAnimator logoFade = ObjectAnimator.ofFloat(fLogo,"alpha",0.0F,1.0F);
        logoFade.setDuration(2500);
        logoFade.start();
    }

    private void animation2(){
        float delta_y = getResources().getDimensionPixelSize(R.dimen.delta_y);
        ObjectAnimator logoYanimation = ObjectAnimator.ofFloat(fLogo,"translationY",0.0F,-delta_y);
        logoYanimation.setInterpolator(new AccelerateDecelerateInterpolator());
        logoYanimation.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(logoYanimation);
        animatorSet.setStartDelay(1000);
        animatorSet.start();


    }

    private void animation3(){

        ObjectAnimator userText = ObjectAnimator.ofFloat(tUser,"alpha",0.0F,0.5F);
        userText.setDuration(1200);
        //Otro Objeto

        ObjectAnimator passText = ObjectAnimator.ofFloat(tPass,"alpha",0.0F,0.5F);
        passText.setDuration(1200);

        ObjectAnimator sessionButton = ObjectAnimator.ofFloat(bSesion, "alpha", 0.0F,1.0F);
        sessionButton.setDuration(1200);
        //Animacion al mismo tiempo
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(userText).with(passText).with(sessionButton);
        animatorSet.setStartDelay(1500);
        animatorSet.start();

    }



    /*private void animation3() {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(welcomeText, "alpha", 0.0F, 1.0F);
        alphaAnimation.setStartDelay(1700);
        alphaAnimation.setDuration(500);
        alphaAnimation.start();
    }
*/


}

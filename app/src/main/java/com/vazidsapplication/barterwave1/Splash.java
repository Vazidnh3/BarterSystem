package com.vazidsapplication.barterwave1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread=new Thread(){
            @Override
            public void run(){
                try{
                    sleep(2000);

                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                }
                Intent intent=new Intent(Splash.this, Login.class);
                startActivity(intent);
                finish();
            }
        };
        thread.start();
    }
}
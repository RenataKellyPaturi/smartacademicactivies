package com.smartacademic.myapplication.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.smartacademic.myapplication.R;

public class AberturaActivity extends AppCompatActivity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IniciaSplash();
    }

    public void IniciaSplash (){

        setContentView(R.layout.activity_abertura);

        new Thread(new Runnable() {

            @Override
            public void run() {

                counter ++;

                try{
                    while (counter == 1 || counter <= 3){

                        Thread.sleep(500);
                        counter++;

                        Log.e("Counter =", Integer.toString(counter));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (counter == 4){


                    Intent it = new Intent(AberturaActivity.this, LoginActivity.class);
                    startActivity(it);

                    counter ++;

                    Log.e("Counter =", Integer.toString(counter));
                }
            }
        }).start();
    }
}

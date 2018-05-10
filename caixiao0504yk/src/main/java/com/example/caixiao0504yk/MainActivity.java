package com.example.caixiao0504yk;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text_time;
    private int i = 3;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int z = msg.what;
            text_time.setText(z+"S");
            if(z == 0){
                Intent it = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(it);
                finish();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_time = findViewById(R.id.text_time);
        new Thread(){
            @Override
            public void run() {

                while(i>0){
                    i--;
                    try {
                        sleep(1000);
                        handler.sendEmptyMessage(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }
}

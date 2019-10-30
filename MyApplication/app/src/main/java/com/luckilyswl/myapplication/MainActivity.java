package com.luckilyswl.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private Button button;
    private TextView textView;

    int num = 0;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.tv);


        handler=new Handler(){
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==1){
                    num++;

                    handler.sendEmptyMessageDelayed(1,500);
                    textView.setText(num+"");
                    Log.e("2", String.valueOf(num));
                }
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacksAndMessages(null);

            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message=new Message();
                message.what=1;
                handler.sendEmptyMessage(message.what);
            }
        },500);




    }
   /* synchronized private void  test(){

        Log.e("2222", String.valueOf(i));
        i++;
    }*/

}

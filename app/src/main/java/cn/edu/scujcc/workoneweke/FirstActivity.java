package cn.edu.scujcc.workoneweke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    private Button fristButton, sendbrodcast,startSecond;
    private final static String TAG = "TEST";
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.d("FristActivity", this.toString());
        Log.d("FristActivity", "onRestart");

        fristButton = findViewById(R.id.fristbutton);
        fristButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(1,getIntent());//将MainActivity传过来的数据传递回去,也可以创建新的Intent传回去
                finish();
            }
        });

        startSecond=findViewById(R.id.startactivity);
        startSecond.setOnClickListener(v->{
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, 1);
        });



        //发送广播
        sendbrodcast = findViewById(R.id.sendbrodcast);
        sendbrodcast.setOnClickListener(v -> {
            Intent intent = new Intent("cn.edu.scujcc.workoneweke.MY_BROADCAST");
            sendBroadcast(intent);
        });
    }
}
package cn.edu.scujcc.workoneweke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    private Button fristButton, sendbrodcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.d("FristActivity", this.toString());
        Log.d("FristActivity", "onRestart");
        fristButton = findViewById(R.id.fristbutton);
        fristButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });
        sendbrodcast = findViewById(R.id.sendbrodcast);
        sendbrodcast.setOnClickListener(v -> {
            Intent intent = new Intent("cn.edu.scujcc.workoneweke.MY_BROADCAST");
            sendBroadcast(intent);
        });
    }
}
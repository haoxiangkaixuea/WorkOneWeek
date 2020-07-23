package cn.edu.scujcc.workoneweke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
private Button FristButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.d("FristActivity",this.toString());
        Log.d("FristActivity","onRestart");
        FristButton=findViewById(R.id.fristbutton);
        FristButton.setOnClickListener(v->{
            Intent intent=new Intent(this,SecondActivity.class);
            startActivity(intent);
        });
    }
}
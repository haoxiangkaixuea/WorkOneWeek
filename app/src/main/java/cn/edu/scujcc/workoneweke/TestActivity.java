package cn.edu.scujcc.workoneweke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    private TextView tv;
    private Button Backmassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //获取Intent后,通过key获取对应的值,然后把值设置给TextView
//        tv = findViewById(R.id.textView);
//        Student s = (Student) getIntent().getSerializableExtra(MainActivity.BASE);
//        tv.setText(s.toString());

        Backmassage = findViewById(R.id.backmassage);
        Backmassage.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("date_return", "你好");
            //把intent传回去
            setResult(RESULT_OK, intent);
            //调用Finnish来销毁当前活动,销毁后会回调到原 AActivity 的 onActivityResult()方法
            finish();
            //在AActivity中得到返回的数据
        });

//        //对应取出数据示例
//        Intent intent=getIntent();
//        int i=intent.getIntExtra("extra_int",0);
//        int[] ints=intent.getIntArrayExtra("extra_int_array");
//        String a=intent.getStringExtra("extra_string");
//        startActivity(intent);

//
//
//    //获取Intent后,通过key获取对应的值,然后把值设置给TextView
//    private void initData() {
//        int base = getIntent().getIntExtra(MainActivity.BASE, 0);
//        tv.setText(String.valueOf(base));
//    }
    }

}
package cn.edu.scujcc.workoneweke;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Administrator
 */
public class TestActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_test);

        Button startFirst = findViewById(R.id.starfristactivity);
        startFirst.setOnClickListener(v -> {
            Intent intent = new Intent(this, FirstActivity.class);
            intent.putExtra(MainActivity.BASE, "for result");
            startActivityForResult(intent, 1);
        });

        //获取Intent后,通过key获取对应的值,然后把值设置给TextView
//        tv = findViewById(R.id.textView);
//        Student s = (Student) getIntent().getSerializableExtra(MainActivity.BASE);
//        tv.setText(s.toString());

//        backMassage = findViewById(R.id.backmassage);
//        backMassage.setOnClickListener(v -> {
//            Intent intent = new Intent();
//            intent.putExtra("date_return", "你好");
//            //把intent传回去
//            setResult(RESULT_OK, intent);
//            //调用Finnish来销毁当前活动,销毁后会回调到原 AActivity 的 onActivityResult()方法
//            finish();
//            //在AActivity中得到返回的数据
//        });

//        //对应取出数据示例
//        Intent intent=getIntent();
//        int i=intent.getIntExtra("extra_int",0);
//        int[] ints=intent.getIntArrayExtra("extra_int_array");
//        String a=intent.getStringExtra("extra_string");
//        startActivity(intent);

//    //获取Intent后,通过key获取对应的值,然后把值设置给TextView
//    private void initData() {
//        int base = getIntent().getIntExtra(MainActivity.BASE, 0);
//        tv.setText(String.valueOf(base));
//    }
    }

    /**
     * 原 Activity 中重写 onActivityResult() 方法
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            // String returndate = data.getStringExtra("date_return");
            //获取Intent后,通过key获取对应的值,然后把值设置给TextView
            //String base = data.getStringExtra("date_return");
            String base = data.getStringExtra(MainActivity.BASE);
            Toast.makeText(this, base, Toast.LENGTH_SHORT).show();
            //getIntent().getIntExtra(MainActivity.BASE, 0);
            //tv1 = findViewById(R.id.textView2);
            //tv1.setText(String.valueOf(base));
            if (base != null) {
                Log.d(TAG, base);
            }
        }
    }
}
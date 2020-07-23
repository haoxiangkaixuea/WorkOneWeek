package cn.edu.scujcc.workoneweke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Sendnews, Starthttp, ReturnNews;
    public final static String BASE = "base";
    private final static String TAG = "TEST";
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Starthttp = findViewById(R.id.starthttp);
        //intent打开网页
        Starthttp.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.baidu.com"));
            //打电话
            intent.setData(Uri.parse("tel:1008611"));
            startActivity(intent);
        });
        //返回数据
        ReturnNews = findViewById(R.id.button2);
        ReturnNews.setOnClickListener(v -> {
            Intent intent = new Intent(this, TestActivity.class);
            startActivityForResult(intent, 1);
        });

        //传递数据
        Sendnews = findViewById(R.id.sendnews);
        Sendnews.setOnClickListener(v -> {
            /**
             * 传递Serializable对象
             */
            Student student = new Student();
            student.setStuName("张三");
            student.setClassName("一班");
            Intent intent = new Intent(this, TestActivity.class);
            intent.putExtra(MainActivity.BASE, student);
            startActivity(intent);
            //Intent 传输数据

            //原 Activity 中启动新 Activity 并请求返回数据
//            startActivityForResult(intent,1);
//            //添加 Extra 示例
//            intent.putExtra("extra_int",1000);
//            int[] ints={1,2,3};
//            intent.putExtra("extra_int_array",ints);
//            intent.putExtra("extra_string","teger Activity");


        });
    }

    //原 Activity 中重写 onActivityResult() 方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
//                    String returndate = data.getStringExtra("date_return");
                    //获取Intent后,通过key获取对应的值,然后把值设置给TextView
                    String base =data.getStringExtra("date_return");
                               // getIntent().getIntExtra(MainActivity.BASE, 0);
                        tv1 = findViewById(R.id.textView2);
                        tv1.setText(String.valueOf(base));
                       // Log.d(TAG, returndate);
                    }
                    break;
                    default:
                }
        }
    }
package cn.edu.scujcc.workoneweke;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {
    public final static String BASE = "base";
    private final static String TAG = "TEST";
    private Button startFirst, startSecond;
    private Button sendNews, startHttp, returnNews;
    private TextView tv1;
    private List<User> userList = new ArrayList<>();

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
        setContentView(R.layout.activity_main);

        imitUser();
        //RecyclerView列表
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        //设置列表的布局方式，使用线性布局
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        //加载到RecyclerView列表中
        recyclerView.setLayoutManager(linearLayout);
        //设置ViewAdapter实例，把数据传入到构造函数中
        ViewAdapter viewAdapter = new ViewAdapter(userList);
        //完成适配器设置
        recyclerView.setAdapter(viewAdapter);


        //生命周期
        startFirst = findViewById(R.id.startfrist);
        startSecond = findViewById(R.id.startsecond);
        startFirst.setOnClickListener(v -> {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        });
        startSecond.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });


        //Intent
        startHttp = findViewById(R.id.starthttp);
        //intent打开网页
        startHttp.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.baidu.com"));
            //打电话
            intent.setData(Uri.parse("tel:1008611"));
            startActivity(intent);
        });
        //返回数据
        returnNews = findViewById(R.id.button2);
        returnNews.setOnClickListener(v -> {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
            //startActivityForResult(intent, 1);
        });

        //传递数据
        sendNews = findViewById(R.id.sendnews);
        sendNews.setOnClickListener(v -> {
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

    private void imitUser() {
        for (int i = 0; i < 2; i++) {
            User zhangsan = new User("张三", R.drawable.ic_launcher_background);
            userList.add(zhangsan);
            User lisi = new User("李四", R.drawable.ic_launcher_background);
            userList.add(lisi);
            User wangwu = new User("王五", R.drawable.ic_launcher_background);
            userList.add(wangwu);
            User liuliu = new User("六六", R.drawable.ic_launcher_background);
            userList.add(liuliu);
            User qiqi = new User("七七", R.drawable.ic_launcher_background);
            userList.add(qiqi);
            User baba = new User("八八", R.drawable.ic_launcher_background);
            userList.add(baba);
            User jiujiu = new User("久久", R.drawable.ic_launcher_background);
            userList.add(jiujiu);
            User shishi = new User("试试", R.drawable.ic_launcher_background);
            userList.add(shishi);
        }
    }

//    //原 Activity 中重写 onActivityResult() 方法
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case 1:
//                if (resultCode == RESULT_OK) {
//                    // String returndate = data.getStringExtra("date_return");
//                    //获取Intent后,通过key获取对应的值,然后把值设置给TextView
//                    String base = data.getStringExtra("date_return");
//                    // getIntent().getIntExtra(MainActivity.BASE, 0);
//                    tv1 = findViewById(R.id.textView2);
//                    tv1.setText(String.valueOf(base));
//                    // Log.d(TAG, returndate);
//                }
//                break;
//            default:
//        }
//    }
}
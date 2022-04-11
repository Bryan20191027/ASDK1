package com.example.weathertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView edittext;
    private TextView tem;
    private TextView tem1;
    private TextView tem2;
    private static final String apiKey = "7sUJ4fEchGA3pixUsoF0U2ai7XchchuX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定义函数
        edittext = (TextView) findViewById(R.id.editText1);
        Button button = (Button) findViewById(R.id.button1);
        final TextView temp = findViewById(R.id.tem);
        final TextView temp1 = findViewById(R.id.tem1);
        final TextView temp2 = findViewById(R.id.tem2);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String my_string = edittext.getText().toString();
                if (TextUtils.isEmpty(my_string)) {
                    Toast.makeText(MainActivity.this, "没有数据输入", Toast.LENGTH_LONG).show();
                } else {
                    //使用api获取数据并提取数据
                    StringBuffer sb = new StringBuffer();
                    try {
                        String weather_url =
                                "http://gfapi.mlogcn.com/weather/v001/now?areacode=101010100&key=4GAIxYFH82pjEVDAdQfqUoDOwwzIQAiS";
                        //101280101为广州 3d为未来3天天气 now为当前天气
                        URL url = new URL(weather_url);
                        URLConnection conn = url.openConnection();
                        InputStream is = conn.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 设置读取流的编码格式，自定义编码
                        BufferedReader reader = new BufferedReader(isr);
                        String line = null;
                        while ((line = reader.readLine()) != null)
                            sb.append(line + " ");
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
                    System.out.printf(sb.toString());



                }
            }
        });

    }


}

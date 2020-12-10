package com.example.testspace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tv_res, tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // активность знает, какой интент ее создал
        // getIntent() - получаем интент, котоый создал эту активность
        // по ключу берем переданные обратно значения
        // get<тип данных>Extra -  нужно указывать тип данных значения, который берем
        String res = getIntent().getStringExtra("RESULT");
        String test = getIntent().getStringExtra("TEST");

        tv_res = (TextView) findViewById(R.id.tv_result);
        tv_test = (TextView) findViewById(R.id.tv_test);

        tv_res.setText(res);
        tv_test.setText(test);
    }
}
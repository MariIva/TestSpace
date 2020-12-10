package com.example.testspace;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt_rule, bt_start, bt_result;

    String res, test;
    final int REQ_C = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_rule = (Button) findViewById(R.id.bt_rule);
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_result = (Button) findViewById(R.id.bt_result);

        // по клику на кнопку будем открывать активность с правилами
        bt_rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создаем явное намерение перехода из MainActivity в RuleActivity
                Intent intent = new Intent(MainActivity.this, RuleActivity.class);
                // запускаем новую активность
                startActivity(intent);
            }
        });
        // по клику на кнопку будем открывать активность с тестом
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Создаем явное намерение перехода из MainActivity в TestActivity
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                // запускаем активность и ожидаем от нее результат по окончании работы
                // REQ_C - метка (код), по которой будем определять какая активность вернула ответ
                startActivityForResult(intent, REQ_C);

            }
        });
        // по клику на кнопку будем открывать активность с результатом
        bt_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создаем явное намерение перехода из MainActivity в ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                // через намерении можно передавать различные значения открываемой активности
                // значения хваранятся в парах ключ-значение
                // по ключу можно взять результат, который с ним хранится
                // ключ лучше всего должен быть константой
                intent.putExtra("RESULT", res);
                intent.putExtra("TEST", test);
                // запускаем новую активность
                startActivity(intent);
            }
        });
    }

    // метод который выполняется, когда активность, вызванная startActivityForResult, заканчивает свою работу
    // requestCode -  метка (код), которую указали в startActivityForResult
    // resultCode - метка (код), как активность закончила работу
    // data - интент, который передается обратно
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQ_C) { // проверяем, какая активность прислала результат
            switch (resultCode) { // проверяем, как активность закончила работу
                case RESULT_OK: // если все хорошо. RESULT_OK - системная константа
                    // по ключу берем переданные обратно значения
                    // get<тип данных>Extra -  нужно указывать тип данных значения, который берем
                    res = data.getStringExtra("RESULT");
                    test = data.getStringExtra("TEST");
                    break;
            }
        }
    }
}
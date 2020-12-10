package com.example.testspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    Button bt_exit, bt_next;
    TextView tv_q;
    RadioGroup radioGroup;

    int res = 0;
    int q = 0;
    Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // создаем объект теста
        test = new Test();
        // устанавливаем название теста
        tv_q = findViewById(R.id.tv_q);
        tv_q.setText(test.questions[0].text);


        radioGroup = (RadioGroup) findViewById(R.id.button_layout);
        // создаем кнопки по количеству ответов в вопросе
        add_button(q);


        bt_exit = (Button) findViewById(R.id.bt_end);
        bt_next = (Button) findViewById(R.id.bt_next);
        // нажание на кнопку "Закончить"
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(q); // проверка правильности ответа
                // создание намерения, для отправки результата в MainActivity
                Intent i = new Intent();
                // передаем обратно количество вопросов и правильных ответов
                i.putExtra("RESULT", res+"/"+test.questions.length);
                i.putExtra("TEST", test.name);
                // устанавливаем значение, как активность закончила работу
                // все прошло без сбоев
                setResult(RESULT_OK, i);
                // прекращаем работу активности
                finish();
            }
        });

        // нажание на кнопку "Следующий"
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(q);// проверка правильности ответа
                // очищаем группу от кнопок
                radioGroup.removeAllViews();
                // переходим на следующий вопрос
                q++;
                // создаем кнопки по количеству ответов в вопросе
                add_button(q);
                // если пришли к последнему вопросу, но кнопка "Следующий" недоступна для клика
                if (q==test.questions.length-1){
                    bt_next.setEnabled(false);
                }
            }
        });

    }

    public void checkAnswer(int q){
        // цикл по количеству ответов в вопросе
        for (int i =0; i< test.questions[q].answer.length; i++) {
            // берем кнопку по Id
            RadioButton btnTag = (RadioButton) findViewById(1000+i);
            // проверяем выбрана ли эта кнопка и номер правильного ответа
            if (btnTag.isChecked() && test.questions[q].isTrue==i+1){
                // если все true, то увеличиваем количество правльных ответов
                res++;
            }
        }
    }

    private void add_button(int q){
        // цикл по количеству ответов в вопросе
        for (int i =0; i< test.questions[q].answer.length; i++) {
            // новая радиокнопка
            RadioButton btnTag = new RadioButton(this);
            // устанавливаем в ней значение
            btnTag.setText(test.questions[q].answer[i]);
            // даем ей Id (лучше не давать значения близкие к 0, они могут использоваться системой)
            btnTag.setId(1000+i);
            // добавляем кнопку в группу
            radioGroup.addView(btnTag);
        }
    }
}
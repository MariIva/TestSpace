package com.example.testspace;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class RuleActivity extends AppCompatActivity {

    TextView tv_rule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        tv_rule = (TextView) findViewById(R.id.tv_rule);
        String result= getResources().getString(R.string.rule1)+"\n"+
                getResources().getString(R.string.rule2)+"\n"+
                getResources().getString(R.string.rule3)+"\n"+
                getResources().getString(R.string.rule4)+"\n"+
                getResources().getString(R.string.rule5);
        tv_rule.setText(result);
    }
}
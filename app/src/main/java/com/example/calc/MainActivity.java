package com.example.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import static com.example.calc.Eval.eval;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button buttonBack;
    private Button buttonBrackets;
    private Button buttonPercent;
    private Button buttonDiv;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonMulty;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonPoint;
    private Button buttonResult;
    private int count = 0;
    private MemResult memResult;
    private final static String KEY_RES = "key_res";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        memResult = new MemResult("test");
    }

    private void initView() {
        tvResult = findViewById(R.id.tv_result);
        button0 = findViewById(R.id.btn_0);
        button0.setOnClickListener(btnListener);
        button1 = findViewById(R.id.btn_1);
        button1.setOnClickListener(btnListener);
        button2 = findViewById(R.id.btn_2);
        button2.setOnClickListener(btnListener);
        button3 = findViewById(R.id.btn_3);
        button3.setOnClickListener(btnListener);
        button4 = findViewById(R.id.btn_4);
        button4.setOnClickListener(btnListener);
        button5 = findViewById(R.id.btn_5);
        button5.setOnClickListener(btnListener);
        button6 = findViewById(R.id.btn_6);
        button6.setOnClickListener(btnListener);
        button7 = findViewById(R.id.btn_7);
        button7.setOnClickListener(btnListener);
        button8 = findViewById(R.id.btn_8);
        button8.setOnClickListener(btnListener);
        button9 = findViewById(R.id.btn_9);
        button9.setOnClickListener(btnListener);
        buttonPercent = findViewById(R.id.btn_degree);
        buttonPercent.setOnClickListener(btnListener);
        buttonDiv = findViewById(R.id.btn_div);
        buttonDiv.setOnClickListener(btnListener);
        buttonMulty = findViewById(R.id.btn_multy);
        buttonMulty.setOnClickListener(btnListener);
        buttonPlus = findViewById(R.id.btn_plus);
        buttonPlus.setOnClickListener(btnListener);
        buttonMinus = findViewById(R.id.btn_minus);
        buttonMinus.setOnClickListener(btnListener);
        buttonPoint = findViewById(R.id.btn_point);
        buttonPoint.setOnClickListener(btnListener);
        buttonBack = findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(btnBackListener);
        buttonBrackets = findViewById(R.id.btn_brackets);
        buttonBrackets.setOnClickListener(btnBracketsListener);
        buttonResult = findViewById(R.id.btn_result);
        buttonResult.setOnClickListener(btnResultListener);
    }

    public View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            String buttonText = button.getText().toString();
            setTextMemory(tvResult, buttonText);
        }
    };

    public View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = tvResult.getText().toString();
            if (str.length() >= 1) {
                if (str.charAt(str.length() - 1) == '(' || str.charAt(str.length() - 1) == ')') {
                    count--;
                }
                str = str.substring(0, str.length() - 1);
                tvResult.setText("");
                setTextMemory(tvResult, str);
            }
        }
    };

    public View.OnClickListener btnResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String result = tvResult.getText().toString();
            tvResult.setText("");
            setTextMemory(tvResult, String.valueOf(eval(result)));

        }
    };

    public View.OnClickListener btnBracketsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count++;
            if (count % 2 == 0) {
                setTextMemory(tvResult, ")");
            }
            setTextMemory(tvResult, "(");
        }
    };

    private void setTextMemory(TextView textMemory, String result) {
        textMemory.append(String.format(Locale.getDefault(), "%S", result));
        memResult.setMemResult(tvResult.getText().toString());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(KEY_RES, memResult);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        memResult = (MemResult) instanceState.getSerializable(KEY_RES);
        setTextMemory(tvResult, memResult.getMemResult());
    }


}
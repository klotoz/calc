package com.example.calc;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivitySecond extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        initRadioGroup();
        initBtnRetirn();
    }

    private void initBtnRetirn() {
        Button button = findViewById(R.id.btnReturn);

        button.setOnClickListener(v -> finish());
    }


    private void initRadioGroup() {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener((radioGroup1, radioButtonID) -> {
            switch (radioButtonID) {
                case R.id.lightThemeBtn:
                    setTheme(R.style.Theme_Calc);
                    break;
                case R.id.darkThemeBtn:
                    setTheme(R.style.Theme_Calc_Dark);
                    break;
            }
        });
    }
}
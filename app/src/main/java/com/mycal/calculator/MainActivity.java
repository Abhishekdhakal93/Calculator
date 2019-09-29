package com.mycal.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView Result;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAdd, btnSub, btnDiv, btnMul,btnDot,btnClear,btnDel,btnEqual;
    int count = 0;
    String doa;
    Numbers number = new Numbers();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDel=findViewById(R.id.btndel);
        btnDel.setOnClickListener(this);
        Result = findViewById(R.id.result);
        Result.setShowSoftInputOnFocus(false);
        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btnAdd = findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(this);
        btnSub = findViewById(R.id.btnsub);
        btnSub.setOnClickListener(this);
        btnMul = findViewById(R.id.btnmul);
        btnMul.setOnClickListener(this);
        btnDiv = findViewById(R.id.btndiv);
        btnDiv.setOnClickListener(this);
        btnEqual = findViewById(R.id.btnequal);
        btnEqual.setOnClickListener(this);
        btnDot = findViewById(R.id.btndot);
        btnDot.setOnClickListener(this);
        btnClear = findViewById(R.id.btnclear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                Result.append("0");
                break;
            case R.id.btn1:
                Result.append("1");
                break;
            case R.id.btn2:
                Result.append("2");
                break;
            case R.id.btn3:
                Result.append("3");
                break;
            case R.id.btn4:
                Result.append("4");
                break;
            case R.id.btn5:
                Result.append("5");
                break;
            case R.id.btn6:
                Result.append("6");
                break;
            case R.id.btn7:
                Result.append("7");
                break;
            case R.id.btn8:
                Result.append("8");
                break;
            case R.id.btn9:
                Result.append("9");
                break;
            case R.id.btndot:
                if ((Result.getText().toString()).contains(".")) {

                } else {
                    Result.append(".");
                }
                break;
            case R.id.btnclear:
                try {
                    String NumberEntered = Result.getText().toString();
                    NumberEntered = NumberEntered.substring(0, NumberEntered.length() - 1);
                    String word = (NumberEntered);
                    Result.setText(word);

                    return;

                } catch (Exception e) {

                    Result.setError("please first enter value");
                }
                break;
            case R.id.btnadd:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "plus";}
                else{
                    Result.setError("only two time");
                }

                break;
            case R.id.btnsub:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "sub";}
                else{
                    Result.setError("only two time");
                }
                break;
            case R.id.btndel:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "del";}
                else{
                    Result.setError("only two time");
                }

                break;
            case R.id.btnmul:
                count++;
                if (count<2){

                    SetData(count);
                    doa = "mul";}
                else{
                    Result.setError("only two time");
                }

                break;
            case R.id.btnequal:
                MathCal mathCal = new MathCal();
                count++;
                SetData(count);
                if (doa.equalsIgnoreCase("plus")) {
                    Result.setText(mathCal.add(number));

                } else if (doa.equalsIgnoreCase("sub")) {
                    Result.setText(mathCal.sub(number));

                } else if (doa.equalsIgnoreCase("div")) {
                    Result.setText(mathCal.divide(number));

                } else if (doa.equalsIgnoreCase("mul")) {
                    Result.setText(mathCal.mul(number));

                }

                break;
            case R.id.btndiv:
                Result.setText("");
                count=0;
        }
    }
    public void SetData(int cou) {

        if (!Result.getText().toString().isEmpty()) {
            if (cou == 1) {
                number.setFirstNumber(Double.parseDouble(Result.getText().toString()));
                Result.setText("");
                return;
            } else if (cou == 2) {
                number.setSecondNumber(Double.parseDouble(Result.getText().toString()));
                Result.setText("");
                return;
            } else {
                Result.setError("only two time");
                return;
            }
        } else {
            Result.setError("please enter the number first");
            count--;
            return;

        }

    }
}

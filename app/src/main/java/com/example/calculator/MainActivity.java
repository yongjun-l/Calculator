package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button enter;
    private Button clear;
    private TextView v_input_1;
    private TextView v_input_2;
    private TextView v_operation;
    private TextView v_answer;
    private String strInput_1 = "";
    private String strInput_2 = "";
    private String strOperation = "";
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=findViewById(R.id.num_1);
        num2=findViewById(R.id.num_2);
        num3=findViewById(R.id.num_3);
        num4=findViewById(R.id.num_4);
        num5=findViewById(R.id.num_5);
        num6=findViewById(R.id.num_6);
        num7=findViewById(R.id.num_7);
        num8=findViewById(R.id.num_8);
        num9=findViewById(R.id.num_9);
        num0=findViewById(R.id.num_0);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multiply=findViewById(R.id.multiple);
        divide=findViewById(R.id.divide);
        enter=findViewById(R.id.enter);
        clear=findViewById(R.id.clear);
        v_input_1=findViewById(R.id.input_1);
        v_input_2=findViewById(R.id.input_2);
        v_operation=findViewById(R.id.operation);
        v_answer=findViewById(R.id.answer);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "1");}
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "2");}
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "3");}
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "4");}
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "5");}
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "6");}
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "7");}
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "8");}
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "9");}
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showNumber(v, "0");}
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showOperation(v, "+"); }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showOperation(v, "-"); }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showOperation(v, "*"); }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showOperation(v, "/"); }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!strInput_1.equals("") | !strInput_2.equals("") | !strOperation.equals("")) {
                    calculate(v, strInput_1, strInput_2, strOperation);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {reset(v);}
        });

    }

    public void showNumber(View v, String num) {
        if (strOperation.equals("")) {
            strInput_1 = strInput_1 + num;
            v_input_1.setText(strInput_1);
            v_input_1.setTextSize(50);
            v_input_1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }
        else{
            strInput_2 = strInput_2 + num;
            v_input_2.setText(strInput_2);
            v_input_2.setTextSize(50);
            v_input_2.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }
    }

    public void showOperation(View v, String op) {
        if (!answer.equals("")) {
            strInput_1=answer;
            v_input_1.setText(answer);
            v_input_1.setTextSize(50);
            v_input_1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }
        strOperation=op;
        v_operation.setText(op);
        v_operation.setTextSize(50);
        v_operation.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
    }

    public void calculate(View v, String input1, String input2, String operation) {
        Double d_input1=Double.parseDouble(input1);
        Double d_input2=Double.parseDouble(input2);
        Double d_answer=0.0;
        if (operation.equals("+")) {
            d_answer = d_input1+d_input2;
        }
        else if (operation.equals("-")) {
            d_answer = d_input1-d_input2;
        }
        else if (operation.equals("*")) {
            d_answer = d_input1*d_input2;
        }
        else if (operation.equals("/")) {
            d_answer = d_input1/d_input2;
        }
        answer=Double.toString(d_answer);
        v_answer.setText(answer);
        v_answer.setTextSize(50);
        v_answer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
    }

    public void reset(View v) {
        strInput_1="";
        strInput_2="";
        strOperation="";
        answer="";
        v_input_1.setText(strInput_1);
        v_input_2.setText(strInput_2);
        v_operation.setText(strOperation);
        v_answer.setText(answer);
    }
}
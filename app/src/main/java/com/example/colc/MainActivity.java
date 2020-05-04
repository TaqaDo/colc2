package com.example.colc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView resultTv;
    String operation;
    Double firstValues, secondValues, result;
    Button point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.resultTv);
        point =findViewById(R.id.point);

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultTv.length() != 0)
                resultTv.append(".");
            }
        });
    }

    public void numberClick(View view) {
        switch (view.getId()) {
            case R.id.clear:
                resultTv.setText("");
                break;
            case R.id.seven:
                resultTv.append("7");
                break;
            case R.id.eight:
                resultTv.append("8");
                break;
            case R.id.one:
                resultTv.append("1");
                break;
            case R.id.two:
                resultTv.append("2");
                break;
            case R.id.three:
                resultTv.append("3");
                break;
            case R.id.four:
                resultTv.append("4");
                break;
            case R.id.five:
                resultTv.append("5");
                break;
            case R.id.six:
                resultTv.append("6");
                break;
            case R.id.nine:
                resultTv.append("9");
                break;
            case R.id.zero:
                if (resultTv.length() != 0)
                resultTv.append("0");
                break;


        }
    }

    public void operandClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(resultTv.getText().toString());
                resultTv.setText(firstValues.toString() + "+");
                break;

            case R.id.divide:
                operation = "/";
                firstValues = Double.valueOf(resultTv.getText().toString());
                resultTv.setText(firstValues.toString() + "/");
                break;
            case R.id.minus:
                operation = "-";
                firstValues = Double.valueOf(resultTv.getText().toString());
                resultTv.setText(firstValues.toString() + "-");
                break;
            case R.id.um:
                operation = "*";
                firstValues = Double.valueOf(resultTv.getText().toString());
                resultTv.setText(firstValues.toString() + "*");
                break;
            case R.id.equals:
                String two = resultTv.getText().toString().replace(firstValues.toString() + operation, "");
                secondValues = Double.valueOf(two);
                switch (operation) {
                    case "+":
                        plusOperation();
                        break;
                    case "-":
                        minusOperation();
                        break;
                    case "*":
                        umOperation();
                        break;

                    case "/":
                        divisionOperation();
                        break;

                }
                break;
        }
    }

    public void plusOperation() {
        result=firstValues+secondValues;
        resultTv.setText(firstValues+"+"+secondValues+"="+result.toString());

    }

    public void minusOperation() {
        result=firstValues-secondValues;
        resultTv.setText(firstValues+"-"+secondValues+"="+result.toString());

    }

    public void divisionOperation() {
        result=firstValues/secondValues;
        resultTv.setText(firstValues+"/"+secondValues+"="+result.toString());

    }


    public void umOperation() {
        result=firstValues*secondValues;
        resultTv.setText(firstValues+"*"+secondValues+"="+result.toString());

    }
}

package com.startandroid.calcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView calcView;
    TextView historyView;
    Boolean isNewNumber = true;
    String expression = "";
    String number;
    String firstOperand;
    String secondOperand;
    String operator = "";
    Double result = 0.0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcView = findViewById(R.id.calcView);
        historyView = findViewById(R.id.historyView);

    }

    public void clickDigit(View v) {
        if (isNewNumber) {
            calcView.setText("");
        }
        isNewNumber = false;

        number = calcView.getText().toString();

        if (v.getId() == R.id.one) {
            number += "1";
        } else if (v.getId() == R.id.two) {
            number += "2";
        } else if (v.getId() == R.id.three) {
            number += "3";
        } else if (v.getId() == R.id.four) {
            number += "4";
        } else if (v.getId() == R.id.five) {
            number += "5";
        } else if (v.getId() == R.id.six) {
            number += "6";
        } else if (v.getId() == R.id.seven) {
            number += "7";
        } else if (v.getId() == R.id.eight) {
            number += "8";
        } else if (v.getId() == R.id.nine) {
            number += "9";
        } else if ((v.getId() == R.id.zero) && (!Objects.equals(number, "0"))) {
            number += "0";
//            calcView.setText(number);
        } else if ((v.getId() == R.id.dot) && (!number.contains("."))) {
            if (Objects.equals(number, "0")) {
                number = "0.";
//                calcView.setText(number);
            } else {
                number += ".";
            }
        }
//        if (number.startsWith("0")) {
//            number = number.substring(1);
//        }
        calcView.setText(number);
    }

    public void clickOperator(View v) {
        isNewNumber = true;
        firstOperand = calcView.getText().toString();
        expression += firstOperand;

        if (v.getId() == R.id.division) {
            operator = "/";
        } else if (v.getId() == R.id.multiply) {
            operator = "*";
        } else if (v.getId() == R.id.subtraction) {
            operator = "-";
        } else if (v.getId() == R.id.sum) {
            operator = "+";
        }
        expression = expression + " " + operator + " ";
    }

    public void clickEquals(View v) {
        secondOperand = calcView.getText().toString();
        expression += secondOperand;

        if (Objects.equals(operator, "/")) {
            result = Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
        } else if (Objects.equals(operator, "*")) {
            result = Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
        } else if (Objects.equals(operator, "-")) {
            result = Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
        } else if (Objects.equals(operator, "+")) {
            result = Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
        }

        calcView.setText(result+"");
//        expression = expression + " = " + result + "\n";
//        historyView.setText(expression);
        historyView.setText(expression + " = " + result + "");
        expression = "";
        operator = "";
    }

    public void clickCalc(View v) {
        calcView.setText("0");
        isNewNumber = true;
    }

    public void clickPercent(View view) {
        if (Objects.equals(operator, "")) {
            number = calcView.getText().toString();
            Double resPercent = Double.parseDouble(number) / 100;
            number = resPercent + "";
            calcView.setText(number);
//            historyView.setText(number);
        } else {
            secondOperand = calcView.getText().toString();
            if (Objects.equals(operator, "/")) {
                result = Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand) * 100;
            } else if (Objects.equals(operator, "*")) {
                result = Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand) / 100;
            } else if (Objects.equals(operator, "-")) {
                result = Double.parseDouble(firstOperand) - (Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand) / 100);
            } else if (Objects.equals(operator, "+")) {
                result = Double.parseDouble(firstOperand) + (Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand) / 100);
            }
            calcView.setText(result + "");
            operator = "";
        }
    }
}
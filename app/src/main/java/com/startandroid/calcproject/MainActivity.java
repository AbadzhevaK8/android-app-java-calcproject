package com.startandroid.calcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


//  create variables.
    MediaPlayer mediaPlayer;
    TextView calcView;
    TextView historyView;
    Boolean isNewNumber = true;
    String expression = "";
    String number = "0";
    String firstOperand;
    String secondOperand;
    String operator = "";
    Double result = 0.0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      initialize the display of the result, history and sound.
        calcView = findViewById(R.id.calcView);
        historyView = findViewById(R.id.historyView);
        mediaPlayer = MediaPlayer.create(this, R.raw.sound_click);
    }

    public void clickDigit(View v) {
        mediaPlayer.start();

//      checking for a new number.
        if (isNewNumber) {
            calcView.setText(""); // empty string!
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
        } else if (v.getId() == R.id.zero)  {
            if (!Objects.equals(number, "0")) {  // check for adding zero (not the first digit).
                number += "0";
            } else if (Objects.equals(number, "")) { // check for adding zero (the first digit).
                number += "0";
            }
        } else if ((v.getId() == R.id.dot) && (!number.contains("."))) { // checking for only one dot
            if (Objects.equals(number, "")) {
                number = "0."; // if zero is first digit.
            } else {
                number += ".";
            }
        }
        if (number.startsWith("0") && (!number.startsWith("0.")) && (!Objects.equals(number, "0"))) { // clean first zero if number needs
            number = number.substring(1);
        }
        calcView.setText(number);
    }

    public void clickOperator(View v) {
        mediaPlayer.start();
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
        mediaPlayer.start();
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



        if (Double.isInfinite(result)) {
            historyView.setText(R.string.divideByZero);
            calcView.setText(R.string.divideByZeroSorry);
        } else {
            expression = expression + " = " + result + "";
            historyView.setText(expression);
            calcView.setText(String.format("%s", result));
        }
        expression += "\n";
        operator = "";
        isNewNumber = true;
    }

    public void clickClear(View v) {
        mediaPlayer.start();
        calcView.setText("0");
        isNewNumber = true;
    }

    public void clickPercent(View v) {
        mediaPlayer.start();
        if (Objects.equals(operator, "")) {
            number = calcView.getText().toString();
            result = Double.parseDouble(number) / 100;
            calcView.setText(result + "");

            expression = expression + number + "% = " + result + "";
            historyView.setText(expression);
            expression += "\n";
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
            calcView.setText(String.format("%s", result));
            operator = "";

            expression = expression + operator + secondOperand + "% = " + result + "";
            historyView.setText(expression);
            expression += "\n";
        }
        isNewNumber = true;
    }


    public void clickSqrt(View v) {
        mediaPlayer.start();
        number = calcView.getText().toString();
        result = Math.sqrt(Double.parseDouble(number));
        calcView.setText(String.format("%s", result));
        isNewNumber = true;

        expression = expression + "√" + number + " = " + result + "";
        historyView.setText(expression);
        expression += "\n";
    }

    public void clickSquare(View v) {
        mediaPlayer.start();
        number = calcView.getText().toString();
        result = Double.parseDouble(number) * Double.parseDouble(number);
        calcView.setText(String.format("%s", result));
        isNewNumber = true;

        expression = expression + number + "\u00B2" + " = " + result + "";
        historyView.setText(expression);
        expression += "\n";
    }
}
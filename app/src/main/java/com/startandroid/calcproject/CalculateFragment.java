package com.startandroid.calcproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.DecimalFormat;
import java.util.Objects;

public class CalculateFragment extends Fragment {

    private static final String TAG = "CalculateFragment";

    SharedViewModel viewModel;
    TextView calcView;
    Boolean isNewNumber = true;
    String number = "0";
    String expression = "";
    String firstOperand;
    String secondOperand;
    String operator = "";
    Double result = 0.0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View calcFragmentView = inflater.inflate(R.layout.fragment_calculate, container, false);

        calcView = calcFragmentView.findViewById(R.id.calcView);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        viewModel.getDataToPass().observe(getViewLifecycleOwner(), data -> {
            Log.v(TAG, data);
            if (Objects.equals(data, "one") ||
                    Objects.equals(data, "two") ||
                    Objects.equals(data, "three") ||
                    Objects.equals(data, "four") ||
                    Objects.equals(data, "five") ||
                    Objects.equals(data, "six") ||
                    Objects.equals(data, "seven") ||
                    Objects.equals(data, "eight") ||
                    Objects.equals(data, "nine") ||
                    Objects.equals(data, "zero") ||
                    Objects.equals(data, "dot")){
                getDigitOrDot(data);
            } else if (Objects.equals(data, "division") ||
                    Objects.equals(data, "multiply") ||
                    Objects.equals(data, "subtraction") ||
                    Objects.equals(data, "sum")) {
                getOperator(data);
            } else if (Objects.equals(data, "equals")) {
                calculateEquals();
            } else if (Objects.equals(data, "clear")) {
                clearCalcView();
            } else if (Objects.equals(data, "percent")) {
                calculatePercent();
            } else if (Objects.equals(data, "root")) {
                calculateSqrt();
            } else if (Objects.equals(data, "square")) {
                calculateSquare();
            }
        });

        return calcFragmentView;
    }


    public void getDigitOrDot(String data) {
        if (isNewNumber) {
            calcView.setText(""); // empty string!
        }
        isNewNumber = false;

        number = calcView.getText().toString();

        if (Objects.equals(data, "one")) {
            number += "1";
        } else if (Objects.equals(data, "two")) {
            number += "2";
        } else if (Objects.equals(data, "three")) {
            number += "3";
        } else if (Objects.equals(data, "four")) {
            number += "4";
        } else if (Objects.equals(data, "five")) {
            number += "5";
        } else if (Objects.equals(data, "six")) {
            number += "6";
        } else if (Objects.equals(data, "seven")) {
            number += "7";
        } else if (Objects.equals(data, "eight")) {
            number += "8";
        } else if (Objects.equals(data, "nine")) {
            number += "9";
        } else if (Objects.equals(data, "zero"))  {
            if (!Objects.equals(number, "0")) {  // check for adding zero (not the first digit).
                number += "0";
            } else if (Objects.equals(number, "")) { // check for adding zero (the first digit).
                number += "0";
            }
        } else if ((Objects.equals(data, "dot")) && (!number.contains("."))) { // checking for only one dot
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

    public void getOperator(String data) {  // read operator to variable.
        isNewNumber = true;
        firstOperand = calcView.getText().toString();
        expression += firstOperand;

        if (Objects.equals(data, "division")) {
            operator = "/";
        } else if (Objects.equals(data, "multiply")) {
            operator = "*";
        } else if (Objects.equals(data, "subtraction")) {
            operator = "-";
        } else if (Objects.equals(data, "sum")) {
            operator = "+";
        }
        expression = expression + " " + operator + " ";
    }

    public void calculateEquals() {
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

        if (Double.isInfinite(result)) {  // checking divide by zero.
            Toast.makeText(getContext(), R.string.divideByZero, Toast.LENGTH_SHORT).show();
        } else {
            expression = expression + " = " + resToStr(result);
//            historyView.setText(expression);
            calcView.setText(resToStr(result));
        }
        expression += "\n";
        operator = "";
        isNewNumber = true;
    }

    public void clearCalcView() {
        calcView.setText("0");
        isNewNumber = true;
    }

    public void calculatePercent() {
        if (Objects.equals(operator, "")) {                    // for one number
            number = calcView.getText().toString();
            result = Double.parseDouble(number) / 100;
            calcView.setText(resToStr(result));

            expression = expression + number + "% = " + resToStr(result);
        } else {                                                  // for expression with percents.
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
            calcView.setText(resToStr(result));
            operator = "";

            expression = expression + operator + secondOperand + "% = " + resToStr(result);
        }
//        historyView.setText(expression);
        expression += "\n";
        isNewNumber = true;
    }

    public void calculateSqrt() {
//        mediaPlayer.start();
        number = calcView.getText().toString();
        result = Math.sqrt(Double.parseDouble(number));
        calcView.setText(resToStr(result));
        isNewNumber = true;

        expression = expression + "√" + number + " = " + resToStr(result);
//        historyView.setText(expression);
        expression += "\n";
    }

    public void calculateSquare() {
        number = calcView.getText().toString();
        result = Double.parseDouble(number) * Double.parseDouble(number);
        calcView.setText(resToStr(result));
        isNewNumber = true;

        expression = expression + number + "\u00B2" + " = " + resToStr(result);
//        historyView.setText(expression);
        expression += "\n";
    }

    public String resToStr(Double result)  {
        if (result % 1 == 0) {
            return Long.toString((long) result.doubleValue());
        } else {
            DecimalFormat decimalFormat = new DecimalFormat( "#.############" );
            String s = decimalFormat.format(result);
            s = s.replaceAll("\\.(.*?)0+$", ".$1");
            return s;
        }
    }
}
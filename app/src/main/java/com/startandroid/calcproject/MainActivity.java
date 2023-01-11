package com.startandroid.calcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnDivision;
    Button btnMult;
    Button btnSubstr;
    Button btnSum;

    Button btnNumSeven;
    Button btnNumEight;
    Button btnNumNine;
    Button btnSqrt;

    Button btnNumFour;
    Button btnNumFive;
    Button btnNumSix;
    Button btnSq;

    Button btnNumOne;
    Button btnNumTwo;
    Button btnNumThree;
    Button btnEqual;

    Button btnComma;
    Button btnZero;
    Button btnPercent;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDivision = findViewById((R.id.division));
        btnDivision.setOnClickListener(this);
        btnMult = findViewById((R.id.multiply));
        btnMult.setOnClickListener(this);
        btnSubstr = findViewById(R.id.subtraction);
        btnSubstr.setOnClickListener(this);
        btnSum = findViewById(R.id.sum);
        btnSum.setOnClickListener(this);

        btnNumSeven = findViewById(R.id.seven);
        btnNumSeven.setOnClickListener(this);
        btnNumEight = findViewById(R.id.eight);
        btnNumEight.setOnClickListener(this);
        btnNumNine = findViewById(R.id.nine);
        btnNumNine.setOnClickListener(this);
        btnSqrt = findViewById(R.id.root);
        btnSqrt.setOnClickListener(this);

        btnNumFour = findViewById(R.id.four);
        btnNumFour.setOnClickListener(this);
        btnNumFive = findViewById(R.id.five);
        btnNumFive.setOnClickListener(this);
        btnNumSix = findViewById(R.id.six);
        btnNumSix.setOnClickListener(this);
        btnSq = findViewById(R.id.square);
        btnSq.setOnClickListener(this);

        btnNumOne = findViewById(R.id.one);
        btnNumOne.setOnClickListener(this);
        btnNumTwo = findViewById(R.id.two);
        btnNumTwo.setOnClickListener(this);
        btnNumThree = findViewById(R.id.three);
        btnNumThree.setOnClickListener(this);
        btnEqual = findViewById(R.id.equals);
        btnEqual.setOnClickListener(this);

        btnComma = findViewById(R.id.comma);
        btnComma.setOnClickListener(this);
        btnZero = findViewById(R.id.zero);
        btnZero.setOnClickListener(this);
        btnPercent = findViewById(R.id.percent);
        btnPercent.setOnClickListener(this);
        btnCalc = findViewById(R.id.calc);
        btnCalc.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
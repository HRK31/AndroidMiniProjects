package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){

        EditText WeightTextNumber = (EditText) findViewById(R.id.WeightTextNumber);


        Log.i("Info", "Button Pressed");

        Log.i("Values", WeightTextNumber.getText().toString());
        System.out.println("Hello Everyone");
    }

    public void calculateBmi(View view) {


            Spinner weightSp = (Spinner)findViewById(R.id.spinnerWeight);
            Spinner heightSp = (Spinner)findViewById(R.id.spinnerHeight);
            String weightSpText = weightSp.getSelectedItem().toString();
            String heightSpText = heightSp.getSelectedItem().toString();
            EditText weightValue = (EditText) findViewById(R.id.WeightTextNumber);
            EditText heightValue = (EditText) findViewById(R.id.HeightTextNumber);
            TextView resultBmi = (TextView) findViewById(R.id.bmiNumber);
            TextView category = (TextView) findViewById(R.id.categoryValue);



            double weight = Double.parseDouble(weightValue.getText().toString());
            double height = Double.parseDouble(heightValue.getText().toString());


            if(weightSpText=="lbs") {
                weight *= 0.453592;
            }

            if(heightSpText=="feet") {
                height *= 0.3048;
            }

            double bmiValue = weight / (height * height);

            String bmiAnswer = String.format("%.2f",bmiValue);

            if (bmiValue < 18.5) {
                category.setText("You are Underweight");
            } else if (bmiValue < 25){
                category.setText("You are Normal");
            } else if (bmiValue < 30) {
                category.setText("You are Overweight");
            } else {
                category.setText("You are Obese");
            }

            resultBmi.setText("Your BMI is "+bmiAnswer);
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
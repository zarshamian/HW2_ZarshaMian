package com.example.zarshamian.hw2;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button myButton;
    EditText myGrade1;
    EditText myGrade2;
    EditText myGrade3;
    EditText myGrade4;
    EditText myGrade5;

    View wholeview;
    int str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView)findViewById(R.id.tv1);
        myGrade1 = (EditText)findViewById(R.id.input_field1);
        myGrade2 = (EditText)findViewById(R.id.input_field2);
        myGrade3 = (EditText)findViewById(R.id.input_field3);
        myGrade4 = (EditText)findViewById(R.id.input_field4);
        myGrade5 = (EditText)findViewById(R.id.input_field5);
        myButton = (Button)findViewById(R.id.btn_compute);
        str = R.string.btn_clear;

        wholeview = this.getWindow().getDecorView();
        wholeview.setBackgroundResource(R.color.white);

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String number1 = myGrade1.getText().toString();
                String number2 = myGrade2.getText().toString();
                String number3 = myGrade3.getText().toString();
                String number4 = myGrade4.getText().toString();
                String number5 = myGrade5.getText().toString();
                if (number1.isEmpty() || number2.isEmpty() || number3.isEmpty() || number4.isEmpty() || number5.isEmpty())
                    Toast.makeText(MainActivity.this, "Empty fields will not be accepted. Fill all fields and try again.", Toast.LENGTH_SHORT).show();
                else
                { compute_gpa(myTextView);}
            }
        });
    }

    public void compute_gpa(View view) {

        myButton.setText(str);
        int num1 = Integer.parseInt(myGrade1.getText().toString());
        int num2 = Integer.parseInt(myGrade2.getText().toString());
        int num3 = Integer.parseInt(myGrade3.getText().toString());
        int num4 = Integer.parseInt(myGrade4.getText().toString());
        int num5 = Integer.parseInt(myGrade5.getText().toString());

           int total = (num1 + num2 + num3 + num4 + num5) / 5;

            myTextView.setText(Integer.toString(total));
            if (total >= 0 && total < 61) {
                wholeview.setBackgroundResource(R.color.red);

            } else if (total > 60 && total < 80) {
                wholeview.setBackgroundResource(R.color.yellow);
            } else if (total > 79 && total < 101) {
                wholeview.setBackgroundResource(R.color.green);
            }
    }

}

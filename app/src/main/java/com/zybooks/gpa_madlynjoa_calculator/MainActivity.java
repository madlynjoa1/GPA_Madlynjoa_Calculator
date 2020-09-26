package com.zybooks.gpa_madlynjoa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView gpaTextV;

    private EditText credit, grade;
    private Button add, calculate,erase;
    double counter=0.0, gradeNUm=0;
    double total_credit=0.0, creditNum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect var to id
       // calculate=findViewById(R.id.calculate)
        credit=findViewById(R.id.creditEditText);
        grade=findViewById(R.id.gradeEditText);
        add=findViewById(R.id.buton1Add);
        gpaTextV=findViewById(R.id.gpaTextView);
        erase=findViewById(R.id.eraseButton);

        calculate=findViewById(R.id.calculate);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditNum= Double.parseDouble(credit.getText().toString());
                gradeNUm= Double.parseDouble(grade.getText().toString());

                if(credit.length()==0){
                    credit.setError("Enter a Credit");
                }
                else if(grade.length()==0){
                    grade.setError("Enter grade");

                }
                else{
                    counter+=(gradeNUm*creditNum);
                    total_credit+=creditNum;
                    Toast.makeText(getApplicationContext(),"Credit:"+credit+"\ngrade : "+grade,Toast.LENGTH_LONG).show();
                    credit.setText("");
                    grade.setText("");
                }


            }});
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result=counter/total_credit;
                gpaTextV.setText("Your Gpa:"+result);
            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=0;
                total_credit=0;
                creditNum=0;
                gradeNUm=0;
                credit.setText("");
                grade.setText("");
                gpaTextV.setText("");
            }
        });
        gpaTextV.setBackgroundColor(Color.WHITE);

    }
}